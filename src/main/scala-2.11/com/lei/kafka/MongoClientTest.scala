package com.lei.kafka


import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.{BasicDBObject, casbah}
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.query.Imports._

import scala.util.{Failure, Success, Try}
import scala.util.parsing.json.JSON


/**
  * Created by Lei on 16/4/5.
  */
object MongoClientTest {
  def main(args: Array[String]) {
    val client = MongoClient("localhost", 27017)
    val db = client("hinews_test")
    val jsonCoder = new ObjectMapper()
    val ctrResult = "{\"2\":{\"26849774\":0.1, \"26849789\":-0.2, \"26850431\":1, \"26849787\":13, \"26849771\":-2, \"26849769\":9},\"15999\":{\"26850431\":0.1}}"

    val ctrDcit = JSON.parseFull(ctrResult).get.asInstanceOf[Map[String, Map[String, Double]]]
    val parseSuccess = Try(JSON.parseFull(ctrResult).get.asInstanceOf[Map[String, Map[String, Double]]])
    parseSuccess match {
      case Failure(x) =>
      //todo
      // add some log here
      case Success(ctrDict) => {
        val userIds = ctrDict.keys.map(_.toInt).toList
        val articleIds = ctrDict.values.flatMap(_.keys).map(_.toInt).toList
        val seqId2GCMMap = retriveGCMByUser(userIds, db)
        val articleMap = retriveArticleBySeqId(articleIds, db)

        val sortedCtrDictList = for (userId <- seqId2GCMMap.keys)
          yield (userId, ctrDict.get(userId).get.toList.sortBy(_._2).reverse.take(10).map(_._1))
        val sortedCtrDict = sortedCtrDictList.toMap
        sortedCtrDict.map {
          entry =>
            val gcm = seqId2GCMMap.get(entry._1.toString).get
            val news = for (articleId <- entry._2)
              yield articleMap.get(articleId).get
            val title = news.head.get("title")
            val img_url = getImgUrl(news.head)
            val m = Map("title" -> title, "img_url" -> img_url, "news" -> collection.JavaConversions.seqAsJavaList(news))
            val mm = Map("to" -> gcm, "data" -> collection.JavaConversions.mapAsJavaMap(m))
            println(jsonCoder.writerWithDefaultPrettyPrinter().writeValueAsString(collection.JavaConversions.mapAsJavaMap(mm)))
        }
      }
    }

  }

  def getImgUrl(doc: DBObject): String = {
    var origin = "http://static.newsdog.today/app_push_android.png"
    try {
      origin = doc.get("related_images").asInstanceOf[BasicDBList].head.asInstanceOf[BasicDBObject].getString("origin")
    }
    catch {
      case _: Throwable =>
    }
    origin
  }

  def retriveArticleBySeqId(ids: List[Int], db: casbah.MongoDB): Map[String, DBObject] = {
    val articleCollection = db("article")
    val q = "seq_id" $in ids
    val doc = articleCollection.find(q, MongoDBObject(
      "title" -> 1,
      "top_images" -> 1,
      "related_images" -> 1,
      "seq_id" -> 1,
      "source" -> 1,
      "source_url" -> 1,
      "published_at" -> 1,
      "comments_count" -> 1,
      "id" -> 1)
    )
    val m = doc.map {
      case obj: DBObject =>
        val sid = obj.get("seq_id").toString
        val id = obj.get(("_id")).toString
        obj.removeField("_id")
        obj.put("id", id)
        (sid, obj)
    }

    m.toMap.asInstanceOf[Map[String, DBObject]]
  }

  def retriveGCMByUser(ids: List[Int], db: casbah.MongoDB): Map[String, String] = {
    val userCollection = db("user")
    val q = "seq_id" $in ids
    val allUser = userCollection.find(q, MongoDBObject("seq_id" -> 1, "accounts.gcm.id" -> 1))
    val gcmUsers = for {u <- allUser
                        uid = u.get("seq_id").toString
                        gcm = try {
                          u.get("accounts").asInstanceOf[BasicDBObject].get("gcm").asInstanceOf[BasicDBObject].get("id")
                        }
                        catch {
                          case _: Throwable => None
                        }
    } yield (uid, gcm)
    gcmUsers.toList.filter { case (_, gcm) => if (gcm != None) true else false }.toMap.asInstanceOf[Map[String, String]]
  }
}

