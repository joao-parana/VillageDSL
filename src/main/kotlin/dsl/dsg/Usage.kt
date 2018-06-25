package dsl.dsg

import se.KotlinScriptEngineFactory

fun main(args: Array<String>) {
    KotlinScriptEngineFactory()
    @DSLBuilder("kotlin.Int") val piTagConfig = 1001
    val temperatura = 301
    val UAM02_PXI_2_T08_C_All = 1248
    val plantDescription = "Usina Hidrelétrica de Itaipu Binacional"

    val plant = elements {
        installationInfo project "SOMA-MATRIX-UG" title "SOMA-MATRIX UG" server "Server01" serverTitle "Server 01" locale "es_PY"
        itens {
          item name "Itaipu" title "Itaipu Binacional" desc plantDescription term "4301" contains {
            item name "Itaipu - Paraguay" title "Itaipu - 50Hz" desc "Usina de Itaipu Lado Paraguai" term "4301" contains {
              item name "U01" title "U01" desc "Unidad Generadora-U01" term "4302" contains {
                item name "UAM01" title "UAM 01" desc "Unidade de Aquisição e Monitoramento da -U01 _ Controladora NI PXI-1"  term "4304" contains {}
                item name "U01_Generador" title "Generador" desc "Generador de la Unidad Generadora-U01" term "4307" contains {}
                item name "U01_Turbina" title "Turbina" desc "Turbina de la Unidad Generadora-U01" term "4307" contains {}
              }
              item name "U02" title "U02" desc "Unidad Generadora-U02" term "4302" contains {
                item name "UAM02" title "UAM 02" desc "Unidade de Aquisição e Monitoramento da -U02 _ Controladora NI PXI-1" term "4304" contains {}
              }
            }
          }
        }

        // }
        // <item id="1" name="Itaipu" title="Itaipu Binacional" description="Usina Hidrelétrica de Itaipu Binacional" parent-ref="" term="4301"/>
        //   <item id="10" name="Itaipu - Paraguay" title="Itaipu - 50Hz" description="Usina de Itaipu Lado Paraguai" parent-ref="1" term="4301"/>
        //     <item id="31" name="U01" title="U01" description="Unidad Generadora-U01" parent-ref="10" term="4302"/>
        //       <item id="111" name="UAM01" title="UAM 01" description="Unidade de Aquisição e Monitoramento da -U01 _ Controladora NI PXI-1" parent-ref="31" term="4304"/>
        //       <item id="201" name="U01_Generador" title="Generador" description="Generador de la Unidad Generadora-U01" parent-ref="31" term="4307"/>
        //       <item id="202" name="U01_Turbina" title="Turbina" description="Turbina de la Unidad Generadora-U01" parent-ref="31" term="4307"/>
        //     <item id="32" name="U02" title="U02" description="Unidad Generadora-U02" parent-ref="10" term="4302"/>
        //       <item id="112" name="UAM02" title="UAM 02" description="Unidade de Aquisição e Monitoramento da -U02 _ Controladora NI PXI-1" parent-ref="32" term="4304"/>

        dataSourceGroup setup "\${enable(IT.debug)}" firstIndex 5 queue UAM02_PXI_2_T08_C_All dsType temperatura item 319 containing dataSources {
            dataSource name "xx" title "title xx " desc "\"config\".capitalize()" with config {
                piTagConfig conf "{tagName:'STH     .MEDICAO NIVEL JUSANTE HJ2 (U18) LM-04           '}"
            }
            dataSource name "yy" title "title yy " desc "\"config\".capitalize().substring(0,3)" with config {
                piTagConfig conf "{tagName:'STH     .MEDICION NIVEL AGUAS ABAJO HJ1 (U7) LM-03       '}"
            }
            dataSource name "zz" title "title zz " desc "\"config\".capitalize()" // desc ${IT}.name
        } terms listOf(4309, 4310, 4312) info "{'item-RTD':'1-\${21+IT.index}', 'item':'1', 'RTD':'\${21+IT.index}', 'Planilha':'Estator'}" using rules {
            rule code "x = 1" title "x vale 1 "
            rule code "debug = true" title "habilitando o DEBUG"

        }
    }

    @DSLBuilder("dsl.dsg.DataSourceGroup")
    val dsg = dataSourceGroup setup "\${enable(IT.debug)}" firstIndex 5 queue UAM02_PXI_2_T08_C_All dsType temperatura item 319 containing dataSources {
        dataSource name "xx" title "title xx " desc "\"config\".capitalize()" with config {
            piTagConfig conf "{tagName:'STH     .MEDICAO NIVEL JUSANTE HJ2 (U18) LM-04           '}"
        }
        dataSource name "yy" title "title yy " desc "\"config\".capitalize().substring(0,3)" with config {
            piTagConfig conf "{tagName:'STH     .MEDICION NIVEL AGUAS ABAJO HJ1 (U7) LM-03       '}"
        }
        dataSource name "zz" title "title zz " desc "\"config\".capitalize()" // desc ${IT}.name
    } terms listOf(4309, 4310, 4312) info "{'item-RTD':'1-\${21+IT.index}', 'item':'1', 'RTD':'\${21+IT.index}', 'Planilha':'Estator'}" using rules {
        rule code "x = 1" title "x vale 1 "
        rule code "debug = true" title "habilitando o DEBUG"
    }

    // Operador invoke executa método merge()
    dsg()

    println("************************************************")
    println(dslSingleton.installationInfos)
    println(dsg.currentDataSourceGroup)
    println(dsg.setup)
    println(dsg.firstIndex)
    println(dsg.queue)
    println(dsg.dataSourceType)
    println(dsg.rules)
    println("************************************************")
}

