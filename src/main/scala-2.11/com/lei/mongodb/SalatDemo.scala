package com.lei.mongodb

import org.bson.types.ObjectId
import org.joda.time.DateTime
import com.novus.salat._
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._
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


//case class Article(seq_id: Int, top_images: List[Map[String, String]], related_images: List[Map[String, String]], usable: Boolean, published_at: DateTime, site_name: String, title: String, @Key("_id") id: ObjectId = new ObjectId)
case class Article(seq_id: Int, usable: Option[Boolean], site_name: Option[String], site_url: Option[String] = Some(""), title: Option[String], @Key("_id") id: ObjectId = new ObjectId)

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

case class User(seq_id: Int, accounts: Map[String, Map[String, String]], @Key("_id") id: ObjectId = new ObjectId)


case class Topic(
                  title: String,
                  block_images: List[Map[String, String]],
                  images: List[Map[String, String]],
                  desc: String,
                  detail: String,
                  @Key("_id") id: ObjectId = new ObjectId()
                )

case class Fuck(title: String, cates: List[Int], extra: Int, name: Int, @Key("_id") id: ObjectId = new ObjectId())

case class GCMResponse(multicast_id: String, success: Int, failure: Int, canonical_ids: Int, results: List[Map[String, String]])

case class Media(site_urls: List[String], is_partner: Boolean, @Key("_id") id: ObjectId = new ObjectId)

object SalatDemo {
  def main(args: Array[String]): Unit = {
    implicit val ctx = new Context {
      val name = "hinews.article"
      override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.WhenNecessary,
        typeHint = "_t")
      override val jsonConfig = JSONConfig(
        dateStrategy = StringDateStrategy(dateFormatter = ISODateTimeFormat.dateTime),
        objectIdStrategy = StringObjectIdStrategy)
    }
    import com.mongodb.casbah.Imports._

    RegisterJodaTimeConversionHelpers()
    RegisterConversionHelpers()
    implicit val serializerFormats = Serialization.formats(NotypeHintsAtJson4S)
    object ArticleDAO extends SalatDAO[Article, ObjectId](collection = MongoClient("localhost", 27017)("hinews_test")("article"))
    //    ArticleDAO.update("seq_id" $eq 31741443, MongoDBObject("$set" -> MongoDBObject("usable" -> false)))
    object FuckDAO extends SalatDAO[Fuck, ObjectId](collection = MongoClient("localhost", 27017)("hinews_test")("fuck"))
    //    FuckDAO.update("title" $eq "hello", MongoDBObject("$inc" -> MongoDBObject("extra" -> 2)), true)
//        FuckDAO.update(("title" $eq "fucka1gain") ++ ("extra" $eq 20), MongoDBObject("$inc" -> MongoDBObject("name" -> 2)), true)

    object MediaDAO extends SalatDAO[Media, ObjectId](collection = MongoClient("localhost", 27017)("hinews_test")("media"))
    val isPartner = MediaDAO.findOne(("site_urls" $eq "www.indiatvnews.com") ++ ("is_partner" $eq true) ).isDefined
    println(isPartner)

  }


}
