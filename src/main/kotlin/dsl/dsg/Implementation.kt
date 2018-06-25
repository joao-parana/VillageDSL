package dsl.dsg

// imports para suportar JSR 223. Veja exemplo listado abaixo:
// https://github.com/JetBrains/kotlin/blob/master/libraries/examples/kotlin-jsr223-local-example/src/test/kotlin/org/jetbrains/kotlin/script/jsr223/KotlinJsr223ScriptEngineIT.kt

//<dependency>
//<groupId>org.jetbrains.kotlin</groupId>
//<artifactId>kotlin-scripting-compiler</artifactId>
//<version>1.2.50</version>
//</dependency>
// import org.jetbrains.kotlin.config.KotlinCompilerVersion
// import org.jetbrains.kotlin.daemon.common.threadCpuTime
// import org.jetbrains.kotlin.cli.common.environment.setIdeaIoUseFallback
import dsl.dsg.model.*
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import javax.script.ScriptEngine
import javax.script.ScriptEngineFactory
import kotlin.annotation.AnnotationRetention.RUNTIME
import java.util.ArrayDeque
import java.util.Deque




//@Target(LOCAL_VARIABLE)
@Retention(RUNTIME)
annotation class DSLBuilder(val desc: String)

fun debugScriptEngine(factory: ScriptEngineFactory) {
    factory.apply {
        println(languageName)
        println(languageVersion)
        println(engineName)
        println(engineVersion)
        println(extensions)
        println(mimeTypes)
        println(names)
        println(getMethodCallSyntax("obj", "method", "arg1", "arg2", "arg3"))
        println(getParameter(ScriptEngine.LANGUAGE_VERSION))
        val sep = System.getProperty("line.separator")
        val prog = arrayOf("val x: Int = 3", "var y = x + 2")
        println(getProgram(*prog))
    }
}

object dslSingleton {
    val jsr223factory = KotlinJsr223JvmLocalScriptEngineFactory()
    val engine = jsr223factory.scriptEngine
    val dummy1 = Class.forName("org.jetbrains.kotlin.cli.jvm.repl.GenericReplCompiler")
    val dummy2 = engine.eval("println(\"config\".capitalize().substring(0,5))")
    var installationInfos = mutableListOf<InstallationInfo>()
    @Deprecated("usar Stack em vez")
    var itens = mutableListOf<Item>()
    var stackOfItens: Deque<MutableList<Item>> = ArrayDeque()
}

// var currentDataSourceGroup: dataSourceGroup? = null
object dataSourceGroup {
    val engine = dslSingleton.engine
    var currentRuleList: List<Rule>? = null
    var currentDataSourceGroup: DataSourceGroup? = null
    var setup: String = ""
    var firstIndex: Int = 0
    var queue: Int = 0
    var item: Int = 0
    var measurementUnit: Int = 0
    var terms: List<Int>? = null
    var info: String = ""
    var dataSourceType: Int = 0
    var rules = mutableListOf<Rule>()

    infix fun containing(dataSources: List<DataSource>) = createDataSourceGroup(dataSources)

    infix fun using(rules: List<Rule>) = createRuleList(rules)

    infix fun setup(r: String): dataSourceGroup {
        dataSourceGroup.setup = r
        return this
    }

    // Guardando os atributos index, queue, dataSourceType para propagar nos objetos DataSource
    infix fun firstIndex(fi: Int): dataSourceGroup {
        dataSourceGroup.firstIndex = fi
        return this
    }

    infix fun queue(q: Int): dataSourceGroup {
        dataSourceGroup.queue = q
        return this
    }

    infix fun dsType(t: Int): dataSourceGroup {
        dataSourceGroup.dataSourceType = t
        return this
    }

    infix fun item(t: Int): dataSourceGroup {
        dataSourceGroup.item = t
        return this
    }

    infix fun measurementUnit(m: Int): dataSourceGroup {
        dataSourceGroup.measurementUnit = m
        return this
    }

    infix fun terms(t: List<Int>): dataSourceGroup {
        dataSourceGroup.terms = t
        return this
    }

    infix fun info(i: String): dataSourceGroup {
        dataSourceGroup.info = i
        return this
    }

    operator fun invoke(): dataSourceGroup = merge()

    fun createDataSourceGroup(dataSources: List<DataSource>): dataSourceGroup {
        currentDataSourceGroup = DataSourceGroup(dataSources)
        currentDataSourceGroup
        println("DEBUG: currentDataSourceGroup = " + currentDataSourceGroup)
        println("""DEBUG: createDataSourceGroup invocado. setup = $setup, firstIndex = $firstIndex, queue = $queue,
            | dataSourceType = $dataSourceType, item = $item, measurementUnit = $measurementUnit,
            | terms = $terms e info = $info """.trimMargin("|"))
        return dataSourceGroup
    }

    fun createRuleList(rules: List<Rule>): dataSourceGroup {
        currentRuleList = rules
        return dataSourceGroup
    }

    fun merge(): dataSourceGroup {
        println("""DEBUG: merge invocado. setup = $setup, firstIndex = $firstIndex, queue = $queue,
            | dataSourceType = $dataSourceType, item = $item, measurementUnit = $measurementUnit,
            | terms = $terms e info = $info """.trimMargin("|"))
        // TODO: ajustar os atributos index, queue, dataSourceType, item, measurementUnit, terms e info nos respectivos DataSource

        return dataSourceGroup
    }

}

object dataSource

@DSLBuilder("dsl.dsg.model.Config")
class ConfigListBuilder {
    val configs = mutableListOf<Config>()

    fun build(): List<Config> = configs

    infix fun Int.conf(configuration: String) {
        val annotations = ConfigListBuilder::class.annotations
        if (!annotations.isEmpty()) {
            println("\n••• annotations =" + annotations.toString())
            val scriptable = annotations.first() as DSLBuilder
            println("\n••• description of Scriptable annotation: ${scriptable.desc}")
        }
        configs.add(Config(this, configuration))
    }
}

fun configs(actions: ConfigListBuilder.() -> Unit): List<Config> {
    val builder = ConfigListBuilder()
    builder.actions()
    return builder.build()
}

fun config(actions: ConfigListBuilder.() -> Unit) = configs(actions)

@DSLBuilder("dsl.dsg.model.DataSource")
class DataSourceListBuilder {
    private var currentDataSource: DataSource? = null
    private val dataSources = mutableListOf<DataSource>()

    fun build(): List<DataSource> = dataSources

    infix fun dataSource.name(name: String): dataSource {
        currentDataSource = DataSource(name)
        dataSources += currentDataSource!!
        return dataSource
    }

    infix fun dataSource.title(t: String): dataSource {
        currentDataSource!!.title = t
        return dataSource
    }

    infix fun dataSource.desc(desc: String): dataSource {
        // TODO: fazer o parser de ${IT.name} quando aparecer e substituir por currentDataSource.name
        // Atenção: é necessário carregar a implemntação Kotlin da JSR 223. Veja o build.gradle.kts abaixo
        // https://github.com/JetBrains/kotlin/blob/master/libraries/examples/kotlin-jsr223-local-example/build.gradle.kts
        var IT = currentDataSource
        //val engine: ScriptEngine? = ScriptEngineManager().getEngineByExtension("kts")
        val jsr223factory = KotlinJsr223JvmLocalScriptEngineFactory()
        // TODO: mover este código pro método merge do objeto dataSourceGroup pois só lá é que odos os atributos estarão resolvidos.
        // TODO: usar javax.script.Bindings
        println(desc)
        val result = dslSingleton.engine.eval(desc)
        currentDataSource!!.description = result as String

        return dataSource
    }

    infix fun dataSource.with(configs: List<Config>) {
        currentDataSource!!.configs = configs
    }

    infix fun dataSource.of(configs: List<Config>) = with(configs)

}

fun dataSources(actions: DataSourceListBuilder.() -> Unit): List<DataSource> {
    val builder = DataSourceListBuilder()
    builder.actions()
    return builder.build()
}

object rule

@DSLBuilder("dsl.dsg.model.Rule")
class RuleListBuilder {
    private var currentRule: Rule? = null
    private val rules = mutableListOf<Rule>()

    fun build(): List<Rule> = rules

    infix fun rule.code(code: String): rule {
        currentRule = Rule(code)
        rules += currentRule!!
        dataSourceGroup.rules = rules
        return rule
    }

    infix fun rule.title(t: String): rule {
        currentRule!!.title = t
        return rule
    }
}

fun rules(actions: RuleListBuilder.() -> Unit): List<Rule> {
    val builder = RuleListBuilder()
    builder.actions()
    return builder.build()
}

// implementando a DSL para installationInfo

object installationInfo

//
//fun installationInfo(actions: InstallationInfoListBuilder.() -> Unit): List<InstallationInfo> {
//    val builder = RuleListBuilder()
//    builder.actions()
//    return builder.build()
//}

@DSLBuilder("dsl.dsg.model.InstallationInfo")
class InstallationInfoListBuilder {
    private var currentInstallationInfo: InstallationInfo? = null
    private val installationInfos = mutableListOf<InstallationInfo>()

    fun build(): List<InstallationInfo> = installationInfos

    infix fun installationInfo.project(projectName : String): installationInfo {
        currentInstallationInfo = InstallationInfo(projectName)
        installationInfos += currentInstallationInfo!!
        dslSingleton.installationInfos = installationInfos
        return installationInfo
    }

    infix fun installationInfo.title(t: String): installationInfo {
        currentInstallationInfo!!.projectTitle = t
        return installationInfo
    }

    infix fun installationInfo.server(t: String): installationInfo {
        currentInstallationInfo!!.instanceName = t
        return installationInfo
    }

    infix fun installationInfo.serverTitle(t: String): installationInfo {
        currentInstallationInfo!!.instanceTitle = t
        return installationInfo
    }

    infix fun installationInfo.locale(t: String): installationInfo {
        currentInstallationInfo!!.locale = t
        return installationInfo
    }
}

fun elements(actions: InstallationInfoListBuilder.() -> Unit): List<InstallationInfo> {
    val builder = InstallationInfoListBuilder()
    builder.actions()
    return builder.build()
}

// items {
//    item name "Itaipu" title "Itaipu Binacional" desc plantDescription term "4301" {
// ...
//    }


