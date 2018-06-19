package se

// import sun.java2d.Disposer
import org.jetbrains.kotlin.cli.common.repl.KotlinJsr223JvmScriptEngineFactoryBase
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine
import java.io.File
import javax.script.ScriptEngine
import javax.script.ScriptEngineFactory
import kotlin.reflect.KClass

class KotlinScriptEngineFactory : KotlinJsr223JvmScriptEngineFactoryBase() {
    override fun getScriptEngine(): ScriptEngine {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val factory: ScriptEngineFactory? = null
    val templateClasspath: List<File> = listOf(File("."))
    val templateClassName: String = ""
    // val getScriptArgs: (ScriptContext, Array<out KClass<out Any>>?) -> ScriptArgsWithTypes?
    val scriptArgsTypes: Array<out KClass<out Any>>? = null

//    override fun getScriptEngine(): ScriptEngine =
//
// (factory!!,
//                    //Disposer.newDisposable(),
//                    templateClasspath,// !!! supply the script classpath here
//                    templateClassName,
//                    null,
//                    // KotlinStandardJsr223ScriptTemplate::class.qualifiedName!!,
//                    scriptArgsTypes)

    //{ ctx, types -> ScriptArgsWithTypes(arrayOf(ctx.getBindings(ScriptContext.ENGINE_SCOPE)), types ?: emptyArray()) }, arrayOf(Bindings::class)


    // TODO: Verificar esta implementação https://github.com/JetBrains/kotlin/blob/master/libraries/tools/kotlin-script-util/src/test/kotlin/org/jetbrains/kotlin/script/util/ScriptUtilIT.kt que testa o compilador Kotlin via utilitário.
    // TODO: considerar https://github.com/JetBrains/kotlin/blob/master/libraries/tools/kotlin-script-util/src/test/resources/scripts/bindings-hello-world.kts no teste acima

}