package dsl.dsg.model

data class Config(val template: Int, val configuration: String)

data class DataSource(val name:String,
                      var title: String = "" ,
                      var description: String = "",
                      val index: Int = -1, val  queue: Int = -1,  val dataSourceType: Int = -1,
                      val item: Int = -1, val measurementUnit: Int = -1, val info:String = "",
                      val term: List<Int>? = null,
                      var configs: List<Config>? = null)

data class DataSourceGroup(val dataSorces: List<DataSource>, var rules:String = "")
