package mysql.slick.database

import play.api.libs.json._

case class A(id: Int, script: String)
object A extends Function2[Int, String, A] {
  implicit val format: OFormat[A] = Json.format[A]
}