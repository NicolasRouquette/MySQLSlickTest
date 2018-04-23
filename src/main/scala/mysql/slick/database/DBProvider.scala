package mysql.slick.database

import slick.jdbc.MySQLProfile.api.Database
import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.{Logger, LoggerFactory}

trait DBProvider
object DBProvider {

  val logger: Logger = LoggerFactory.getLogger(classOf[DBProvider])
  logger.info("DBProvider")
  val config: Config = ConfigFactory.load("application")
  val get: Database = Database.forConfig("db.test", config)
}
