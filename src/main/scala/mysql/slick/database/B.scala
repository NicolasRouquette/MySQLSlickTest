package mysql.slick.database

import play.api.libs.json._

case class B(id: Int,
             aid: Int)
object B extends Function2[Int, Int, B] {
  implicit val format: OFormat[B] =
    Json.format[B]
}