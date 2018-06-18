package dsl.dsg

fun main(args: Array<String>) {

    val piTagConfig = 1001
    val dsg = dataSourceGroup containing dataSources {
        dataSource name "xx" title "title xx " desc "desc xx" with config {
            piTagConfig conf "{tagName:'STH     .MEDICAO NIVEL JUSANTE HJ2 (U18) LM-04           '}"
        }
        dataSource  name "yy" title "title yy " desc "desc yy"  with config {
            piTagConfig conf "{tagName:'STH     .MEDICION NIVEL AGUAS ABAJO HJ1 (U7) LM-03       '}"
        }
        dataSource  name "zz" title "title zz " desc "desc \${IT}.name"
    }

    print(dsg)
}
