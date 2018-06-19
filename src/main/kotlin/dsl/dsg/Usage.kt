package dsl.dsg

fun main(args: Array<String>) {

    val piTagConfig = 1001
    val temperatura = 301
    val UAM02_PXI_2_T08_C_All = 1248

    val dsg = dataSourceGroup firstIndex 5 queue UAM02_PXI_2_T08_C_All dsType temperatura item 319 containing dataSources {
        dataSource name "xx" title "title xx " desc "desc xx" with config {
            piTagConfig conf "{tagName:'STH     .MEDICAO NIVEL JUSANTE HJ2 (U18) LM-04           '}"
        }
        dataSource name "yy" title "title yy " desc "desc yy" with config {
            piTagConfig conf "{tagName:'STH     .MEDICION NIVEL AGUAS ABAJO HJ1 (U7) LM-03       '}"
        }
        dataSource name "zz" title "title zz " desc "desc \${IT}.name"
    } setup "\${enable(IT.debug)}" terms listOf(4309,4310,4312) info "{'item-RTD':'1-\${21+IT.index}', 'item':'1', 'RTD':'\${21+IT.index}', 'Planilha':'Estator'}" using rules {
        rule code "x = 1" title "x vale 1 "
        rule code "debug = true" title "habilitando o DEBUG"
    }

    // Operador invoke executa método merge()
    dsg()

    println("************************************************")
    println(dsg.currentDataSourceGroup)
    println(dsg.setup)
    println(dsg.firstIndex)
    println(dsg.queue)
    println(dsg.dataSourceType)
    println(dsg.rules)
    println("************************************************")
}
