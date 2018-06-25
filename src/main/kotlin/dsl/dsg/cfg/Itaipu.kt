package dsl.dsg.cfg

object itaipuPlant {

    val installationInfo = mapOf("projectName" to "SOMA-MATRIX-UG", "projectTitle" to "SOMA-MATRIX UG",
            "instanceName" to "Server01", "instanceTitle" to "Server 01", "locale" to "es_PY")

}

/*


    <item-list>
        <item id="1" name="Itaipu" title="Itaipu Binacional" description="Usina Hidrelétrica de Itaipu Binacional" parent-ref="" term="4301"/>
        <item id="10" name="Itaipu - Paraguay" title="Itaipu - 50Hz" description="Usina de Itaipu Lado Paraguai" parent-ref="1" term="4301"/>
        <item id="31" name="U01" title="U01" description="Unidad Generadora-U01" parent-ref="10" term="4302"/>
        <item id="32" name="U02" title="U02" description="Unidad Generadora-U02" parent-ref="10" term="4302"/>
        <item id="111" name="UAM01" title="UAM 01" description="Unidade de Aquisição e Monitoramento da -U01 _ Controladora NI PXI-1" parent-ref="31" term="4304"/>
        <item id="112" name="UAM02" title="UAM 02" description="Unidade de Aquisição e Monitoramento da -U02 _ Controladora NI PXI-1" parent-ref="32" term="4304"/>
        <item id="201" name="U01_Generador" title="Generador" description="Generador de la Unidad Generadora-U01" parent-ref="31" term="4307"/>
        <item id="202" name="U01_Turbina" title="Turbina" description="Turbina de la Unidad Generadora-U01" parent-ref="31" term="4307"/>
        <item id="203" name="U01_zReservas" title="Reservas" description="Reservas de la Unidad Generadora-U01" parent-ref="31" term="4307"/>
        <item id="204" name="U01_AguaPura" title="Agua Pura" description="Agua Pura de la Unidad Generadora-U01" parent-ref="201" term="4307"/>
        <item id="205" name="U01_Fases" title="Fases" description="Fases del Acoplador de la Unidad Generadora-U01" parent-ref="201" term="4307"/>
        <item id="206" name="U01_Estator" title="Estator" description="Estator de la Unidad Generadora-U01" parent-ref="201" term="4307"/>
        <item id="207" name="U01_CojineteGuiaSuperior" title="Cojinete Guia Superior" description="Cojinete Guia Superior del Generador de la Unidad Generadora-U01" parent-ref="201" term="4307"/>
        <item id="208" name="U01_CojineteCombinado" title="Cojinete Combinado" description="Cojinete Combinado del Generador de la Unidad Generadora-U01" parent-ref="201" term="4307"/>
        <item id="209" name="U01_SegmGuiaTurb" title="Segm Guia" description="Segm Guia de la Turbina de la Unidad Generadora-U01" parent-ref="202" term="4307"/>
        <item id="210" name="U01_Agua_Turbina" title="Agua" description="Agua de la Turbina de la Unidad Generadora-U01" parent-ref="202" term="4307"/>
        <item id="211" name="U01_CajaEspiral_Turbina" title="Caja Espiral" description="Caja Espiral de la Turbina de la Unidad Generadora-U01" parent-ref="202" term="4307"/>
        <item id="212" name="U01_Aceite_Turbina" title="Aceite" description="Aceite de la Turbina de la Unidad Generadora-U01" parent-ref="202" term="4307"/>
        <item id="213" name="U01_Tapa_Turbina" title="Tapa" description="Tapa de la Turbina de la Unidad Generadora-U01" parent-ref="202" term="4307"/>
        <item id="214" name="U01_TuboDeSuccion_Turbina" title="Tubo de Succión" description="Tubo de Succión de la Turbina de la Unidad Generadora-U01" parent-ref="202" term="4307"/>
        <item id="215" name="U01_AguaRadiadores_Estator" title="Agua Radiadores" description="Agua Radiadores del Estator de la Unidad Generadora-U01" parent-ref="206" term="4307"/>
        <item id="216" name="U01_ColdAir_Estator" title="Cold Air" description="Cold Air del Estator de la Unidad Generadora-U01" parent-ref="206" term="4307"/>
        <item id="217" name="U01_HotdAir_Estator" title="Hot Air" description="Hot Air del Estator de la Unidad Generadora-U01" parent-ref="206" term="4307"/>
        <item id="218" name="U01_Bobinado_Estator" title="Bobinado" description="Bobinado del Estator de la Unidad Generadora-U01" parent-ref="206" term="4307"/>
        <item id="219" name="U01_Nucleo_Estator" title="Núcleo" description="Núcleo del Estator de la Unidad Generadora-U01" parent-ref="206" term="4307"/>
        <item id="220" name="U01_AguaSalida_CojineteCombinado" title="Agua Salida" description="Agua Salida del Cojinete Combinado de la Unidad Generadora-U01" parent-ref="208" term="4307"/>
        <item id="221" name="U01_Aceite_CojineteCombinado" title="Aceite" description="Aceite del Cojinete Combinado de la Unidad Generadora-U01" parent-ref="208" term="4307"/>
        <item id="222" name="U01_SegmEmpuje_CojineteCombinado" title="Segm Empuje" description="Segm Empuje del Cojinete Combinado de la Unidad Generadora-U01" parent-ref="208" term="4307"/>
        <item id="223" name="U01_SegmGuia_CojineteCombinado" title="Segm Guia" description="Segm Guia del Cojinete Combinado de la Unidad Generadora-U01" parent-ref="208" term="4307"/>
        <item id="224" name="U01_Agua_CojineteGuiaSuperior" title="Agua" description="Agua del Cojinete Guia Superior de la Unidad Generadora-U01" parent-ref="207" term="4307"/>
        <item id="225" name="U01_Aceite_CojineteGuiaSuperior" title="Aceite" description="Aceite del Cojinete Guia Superior de la Unidad Generadora-U01" parent-ref="207" term="4307"/>
        <item id="226" name="U01_Segm Guia_CojineteGuiaSuperior" title="Segm Guia" description="Segm Guia del Cojinete Guia Superior de la Unidad Generadora-U01" parent-ref="207" term="4307"/>
        <item id="227" name="U01_PO" title="Parámetros Operativos" description="Parámetros Operativos de la Unidad Generadora-U01" parent-ref="31" term="4307"/>
        <item id="228" name="U01_FaseA" title="Fase A" description="Fase A del Generador de la Unidad Generadora-U01" parent-ref="205" term="4307"/>
        <item id="229" name="U01_FaseB" title="Fase B" description="Fase B del Generador de la Unidad Generadora-U01" parent-ref="205" term="4307"/>
        <item id="230" name="U01_FaseC" title="Fase C" description="Fase C del Generador de la Unidad Generadora-U01" parent-ref="205" term="4307"/>
        <item id="301" name="U02_Generador" title="Generador" description="Generador de la Unidad Generadora-U02" parent-ref="32" term="4307"/>
        <item id="302" name="U02_Turbina" title="Turbina" description="Turbina de la Unidad Generadora-U02" parent-ref="32" term="4307"/>
        <item id="303" name="U02_zReservas" title="Reservas" description="Reservas de la Unidad Generadora-U02" parent-ref="32" term="4307"/>
        <item id="304" name="U02_AguaPura" title="Agua Pura" description="Agua Pura de la Unidad Generadora-U02" parent-ref="301" term="4307"/>
        <item id="305" name="U02_Fases" title="Fases" description="Fases del Acoplador de la Unidad Generadora-U02" parent-ref="301" term="4307"/>
        <item id="306" name="U02_Estator" title="Estator" description="Estator de la Unidad Generadora-U02" parent-ref="301" term="4307"/>
        <item id="307" name="U02_CojineteGuiaSuperior" title="Cojinete Guia Superior" description="Cojinete Guia Superior del Generador de la Unidad Generadora-U02" parent-ref="301" term="4307"/>
        <item id="308" name="U02_CojineteCombinado" title="Cojinete Combinado" description="Cojinete Combinado del Generador de la Unidad Generadora-U02" parent-ref="301" term="4307"/>
        <item id="309" name="U02_SegmGuiaTurb" title="Segm Guia" description="Segm Guia de la Turbina de la Unidad Generadora-U02" parent-ref="302" term="4307"/>
        <item id="310" name="U02_Agua_Turbina" title="Agua" description="Agua de la Turbina de la Unidad Generadora-U02" parent-ref="302" term="4307"/>
        <item id="311" name="U02_CajaEspiral_Reservas" title="Caja Espiral" description="Caja Espiral de la Turbina de la Unidad Generadora-U02" parent-ref="302" term="4307"/>
        <item id="312" name="U02_Aceite_Turbina" title="Aceite" description="Aceite de la Turbina de la Unidad Generadora-U02" parent-ref="302" term="4307"/>
        <item id="313" name="U02_Tapa_Turbina" title="Tapa" description="Tapa de la Turbina de la Unidad Generadora-U02" parent-ref="302" term="4307"/>
        <item id="314" name="U02_TuboDeSuccion_Turbina" title="Tubo de Succión" description="Tubo de Succión de la Turbina de la Unidad Generadora-U02" parent-ref="302" term="4307"/>
        <item id="315" name="U02_AguaRadiadores_Estator" title="Agua Radiadores" description="Agua Radiadores del Estator de la Unidad Generadora-U02" parent-ref="306" term="4307"/>
        <item id="316" name="U02_ColdAir_Estator" title="Cold Air" description="Cold Air del Estator de la Unidad Generadora-U02" parent-ref="306" term="4307"/>
        <item id="317" name="U02_HotdAir_Estator" title="Hot Air" description="Hot Air del Estator de la Unidad Generadora-U02" parent-ref="306" term="4307"/>
        <item id="318" name="U02_Bobinado_Estator" title="Bobinado" description="Bobinado del Estator de la Unidad Generadora-U02" parent-ref="306" term="4307"/>
        <item id="319" name="U02_Nucleo_Estator" title="Núcleo" description="Núcleo del Estator de la Unidad Generadora-U02" parent-ref="306" term="4307"/>
        <item id="320" name="U02_AguaSalida_CojineteCombinado" title="Agua Salida" description="Agua Salida del Cojinete Combinado de la Unidad Generadora-U02" parent-ref="308" term="4307"/>
        <item id="321" name="U02_Aceite_CojineteCombinado" title="Aceite" description="Aceite del Cojinete Combinado de la Unidad Generadora-U02" parent-ref="308" term="4307"/>
        <item id="322" name="U02_SegmEmpuje_CojineteCombinado" title="Segm Empuje" description="Segm Empuje del Cojinete Combinado de la Unidad Generadora-U02" parent-ref="308" term="4307"/>
        <item id="323" name="U02_SegmGuia_CojineteCombinado" title="Segm Guia" description="Segm Guia del Cojinete Combinado de la Unidad Generadora-U02" parent-ref="308" term="4307"/>
        <item id="324" name="U02_Agua_CojineteGuiaSuperior" title="Agua" description="Agua del Cojinete Guia Superior de la Unidad Generadora-U02" parent-ref="307" term="4307"/>
        <item id="325" name="U02_Aceite_CojineteGuiaSuperior" title="Aceite" description="Aceite del Cojinete Guia Superior de la Unidad Generadora-U02" parent-ref="307" term="4307"/>
        <item id="326" name="U02_Segm Guia_CojineteGuiaSuperior" title="Segm Guia" description="Segm Guia del Cojinete Guia Superior de la Unidad Generadora-U02" parent-ref="307" term="4307"/>
        <item id="327" name="U02_PO" title="Parámetros Operativos" description="Parámetros Operativos de la Unidad Generadora-U02" parent-ref="32" term="4307"/>
        <item id="328" name="U02_FaseA" title="Fase A" description="Fase A del Generador de la Unidad Generadora-U02" parent-ref="305" term="4307"/>
        <item id="329" name="U02_FaseB" title="Fase B" description="Fase B del Generador de la Unidad Generadora-U02" parent-ref="305" term="4307"/>
        <item id="330" name="U02_FaseC" title="Fase C" description="Fase C del Generador de la Unidad Generadora-U02" parent-ref="305" term="4307"/>
    </item-list>

 */