package mysql.slick.database.test

import mysql.slick.database.{DBProvider, Tables}
import slick.jdbc.MySQLProfile.api.{Database, _}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * To execute with a local MySQL sever:
  *
  * -Ddb.caesar.url=-Ddb.default.url=jdbc:mysql://localhost:3306
  */
object Create_CaesarSlickService_Tables {

  def main(args: Array[String]): Unit = {

    val db: Database = DBProvider.get
    try {
      val setup = DBIO.seq(Tables.schema.create)
      Await.result(db.run(setup), Duration.Inf)
    } finally {
      db.close()
    }
  }
}
