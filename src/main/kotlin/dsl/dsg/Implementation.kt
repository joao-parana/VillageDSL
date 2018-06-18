package dsl.dsg

import dsl.dsg.model.Config
import dsl.dsg.model.DataSource
import dsl.dsg.model.DataSourceGroup
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

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
import java.lang.management.ManagementFactory
import javax.script.ScriptEngineFactory

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

object dataSourceGroup {
    infix fun containing(dataSources: List<DataSource>) = DataSourceGroup(dataSources)
}

object dataSource

class ConfigListBuilder {
    val configs = mutableListOf<Config>()

    fun build(): List<Config> = configs

    infix fun Int.conf(configuration: String) {
        configs.add(Config(this, configuration))
    }
}

fun configs(actions: ConfigListBuilder.() -> Unit): List<Config> {
    val builder = ConfigListBuilder()
    builder.actions()
    return builder.build()
}

fun config(actions: ConfigListBuilder.() -> Unit) = configs(actions)

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
        val engine: ScriptEngine? = ScriptEngineManager().getEngineByExtension("kts")

        if (engine == null) {
            println("Atenção: houve um erro quando tentava-se carregar a Kotlin Script Engine")
            currentDataSource!!.description = desc
            // Ver https://stackoverflow.com/questions/44781462/kotlin-jsr-223-scriptenginefactory-within-the-fat-jar-cannot-find-kotlin-compi
            
        } else {
            val factory = engine.factory
            debugScriptEngine(factory)
            val result = engine.eval(desc)
            //val res = engine.eval("x + 2")
            //Assert.assertEquals(5, res)
            currentDataSource!!.description = result as String
        }
        return dataSource
    }

    infix fun dataSource.with(configs: List<Config>) {
        currentDataSource!!.configs = configs
    }

    infix fun dataSource.of(configs: List<Config>) = with(configs)

    //    @Suppress("UNUSED_PARAMETER")
    //    infix fun dataSource.without(c: configs) {
    //        dataSources += DataSource("")
    //    }

}

fun dataSources(actions: DataSourceListBuilder.() -> Unit): List<DataSource> {
    val builder = DataSourceListBuilder()
    builder.actions()
    return builder.build()
}
