package dsl.dsg

fun main(args: Array<String>) {

    val piTagConfig = 1001
    val temperatura = 301
    val UAM02_PXI_2_T08_C_All = 1248

    val dsg = dataSourceGroup containing dataSources {
        dataSource name "xx" title "title xx " desc "desc xx" with config {
            piTagConfig conf "{tagName:'STH     .MEDICAO NIVEL JUSANTE HJ2 (U18) LM-04           '}"
        }
        dataSource name "yy" title "title yy " desc "desc yy" with config {
            piTagConfig conf "{tagName:'STH     .MEDICION NIVEL AGUAS ABAJO HJ1 (U7) LM-03       '}"
        }
        dataSource name "zz" title "title zz " desc "desc \${IT}.name"
    } rules "xyz é uma regra foda" firstIndex 5 queue UAM02_PXI_2_T08_C_All dataSourceType temperatura

    // Operador invoke executa método merge()
    dsg()

    println("************************************************")
    println(dsg.currentDataSourceGroup)
    println(dsg.rules)
    println(dsg.firstIndex)
    println(dsg.queue)
    println(dsg.dataSourceType)
    println("************************************************")
}
