package mysql.slick.database

object Tables extends {
  val profile = slick.jdbc.MySQLProfile

} with Tables

trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  val schemaName = "mysql_slick"

  lazy val schema: profile.SchemaDescription = Array(
    ATable.schema,
    BTable.schema
  ).reduceLeft(_ ++ _)

  implicit def GetResultA(implicit e0: GR[Int], e1: GR[String]): GR[A] =
    GR { prs =>
      import prs._
      A.tupled((<<[Int], <<[String]))
    }

  class ATable(_tableTag: Tag)
      extends profile.api.Table[A](_tableTag, Some(schemaName), "A") {
    def * = (id, script) <> (A.tupled, A.unapply)

    def ? =
      (Rep.Some(id), Rep.Some(script)).shaped.<>(
        { r =>
          import r._; _1.map(_ => A.tupled((_1.get, _2.get)))
        },
        (_: Any) =>
          throw new Exception("Inserting into ? projection not supported."))

    val id: Rep[Int] = column[Int]("Id", O.AutoInc, O.PrimaryKey)

    val script: Rep[String] =
      column[String]("Script", O.Length(500, varying = true))
  }

  lazy val ATable = new TableQuery(tag => new ATable(tag))

  implicit def GetResultB(implicit e0: GR[Int]): GR[B] = GR { prs =>
    import prs._
    B.tupled((<<[Int], <<[Int]))
  }

  class BTable(_tableTag: Tag)
      extends profile.api.Table[B](_tableTag, Some(schemaName), "B") {
    def * =
      (id, aid) <> (B.tupled, B.unapply)

    def ? =
      (Rep.Some(id), Rep.Some(aid)).shaped
        .<>({ r =>
              import r._;
              _1.map(_ => B.tupled((_1.get, _2.get)))
            },
            (_: Any) =>
              throw new Exception("Inserting into ? projection not supported."))

    val id: Rep[Int] = column[Int]("Id", O.AutoInc, O.PrimaryKey)

    val aid: Rep[Int] = column[Int]("AId")

    lazy val aTableFK = foreignKey("fkA_B", aid, ATable)(
      r => r.id,
      onUpdate = ForeignKeyAction.NoAction,
      onDelete = ForeignKeyAction.NoAction)
  }

  /** Collection-like TableQuery object for table BTable */
  lazy val BTable = new TableQuery(tag => new BTable(tag))

}
