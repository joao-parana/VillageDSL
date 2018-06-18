package dsl.dsg.model

data class Config(val template: Int, val configuration: String)

data class DataSource(val name:String,
                      var title: String = "" ,
                      var description: String = "",
                      // val index: Int, val  queue: Long,  val dataSourceType: Long,
                      // val item: Long, val measurementUnit: Long, val info:String,
                      // val term: List<Long>,
                      var configs: List<Config>? = null)

data class DataSourceGroup(val dataSorces: List<DataSource>)
