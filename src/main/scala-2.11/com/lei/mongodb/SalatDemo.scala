package com.lei.mongodb

import org.bson.types.ObjectId
import org.joda.time.DateTime
import com.novus.salat._
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.commons.conversions.scala.{RegisterConversionHelpers, RegisterJodaTimeConversionHelpers}
import com.novus.salat.dao._
import com.novus.salat.json.{JSONConfig, StringDateStrategy, StringObjectIdStrategy}
import org.joda.time.format.ISODateTimeFormat
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization._
import org.json4s.{NoTypeHints => NotypeHintsAtJson4S}

import scala.util.{Random, Try}

/**
  * Created by Lei on 16/9/27.
  */

package object context {
  implicit val ctx = new Context {
    val name = "hinews.article"
    override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.WhenNecessary,
      typeHint = "_t")
    override val jsonConfig = JSONConfig(
      dateStrategy = StringDateStrategy(dateFormatter = ISODateTimeFormat.dateTime),
      objectIdStrategy = StringObjectIdStrategy)
  }
}

case class Article(seq_id: Int, top_images: List[Map[String, String]], related_images: List[Map[String, String]], usable: Boolean, published_at: DateTime, site_name: String, title: String, @Key("_id") id: ObjectId = new ObjectId)

case class AutoPush(
                     title: String,
                     image: String,
                     scheduler_time: DateTime,
                     bigger: Boolean,
                     enable: Boolean,
                     last_modifier: String,
                     language: String,
                     `type`: Option[String] = Some("single"),
                     article: Option[Int],
                     articles: Option[List[Int]],
                     start_at: Option[DateTime],
                     push_id: Option[Int],
                     finish_at: Option[DateTime],
                     xiaomi: Option[String],
                     send_to_ios: Option[Boolean] = Some(false),
                     finished: Option[Boolean] = Some(false),
                     @Key("_id") id: ObjectId = new ObjectId
                   )

case class User(accounts: Map[String, Map[String, String]], @Key("_id") id: ObjectId = new ObjectId)


object SalatDemo {
  def main(args: Array[String]): Unit = {
    import context._

    RegisterJodaTimeConversionHelpers()
    RegisterConversionHelpers()
    implicit val serializerFormats = Serialization.formats(NotypeHintsAtJson4S)
    object ArticleDAOTEST extends SalatDAO[Article, ObjectId](collection = MongoClient("127.0.0.1", 27017)("hinews_test")("article"))
    object UserDAO extends SalatDAO[User, ObjectId](collection = MongoClient("127.0.0.1", 27017)("hinews_test")("user"))
    //    println(UserDAO.find("accounts" $exists false).toList)
    ArticleDAOTEST.find("seq_id" $in List(31741440))
      .toList
      .map(grater[Article].toPrettyJSON)
      .map(parse(_))
      .map(_ transformField {
        case ("_id", x) => ("id", x)
      })
      .map(_ merge parse("""{"type":"article"}"""))
      .foreach(u=>println(write(u)))

    //    val a = ArticleDAOTEST.findOne("_id" $eq new ObjectId("5721de791290714440bacdc8")).get
    //    object AutoPushDAO extends SalatDAO[AutoPush, ObjectId](collection = MongoClient("127.0.0.1", 27017)("hinews_test")("autopush"))
    //    val q = ("enable" $eq true) ++ ("scheduler_time" $lte new DateTime()) ++ ("finished" $ne true)
    //    val recordOpt = AutoPushDAO.findOne(q)
    //    println(recordOpt.get)
    //
    //    AutoPushDAO.find(MongoDBObject()).foreach(println)

  }


}
