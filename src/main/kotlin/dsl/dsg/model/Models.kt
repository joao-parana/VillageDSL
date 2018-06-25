package dsl.dsg.model

data class Config(val template: Int, val configuration: String)

data class DataSource(val name: String,
                      var title: String = "",
                      var description: String = "",
                      val index: Int = -1, val queue: Int = -1, val dataSourceType: Int = -1,
                      val item: Int = -1, val measurementUnit: Int = -1, val info: String = "",
                      val terms: List<Int>? = null,
                      var configs: List<Config>? = null)

data class DataSourceGroup(val dataSorces: List<DataSource>, var rules: String = "", var debug: Boolean = false)

data class Rule(val code: String, var title: String = "")

data class InstallationInfo(val projectName: String, var projectTitle: String = "",
                            var instanceName: String = "", var instanceTitle: String = "", var locale: String = "")

// item name "Itaipu" title "Itaipu Binacional" desc "Esta é ..." term "4301"
data class Item(val name: String, var title: String = "", var desc: String = "", var term: String = "")

