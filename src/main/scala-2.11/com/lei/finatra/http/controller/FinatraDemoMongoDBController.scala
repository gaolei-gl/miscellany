package com.lei.finatra.http.controller

import javax.inject.{Inject, Singleton}

import com.google.common.cache.CacheBuilder
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.utils.FuturePools

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scalacache.{NoSerialization, ScalaCache, typed}
import scalacache.guava.GuavaCache
import scalacache._

/**
  * Created by Lei on 2017/1/2.
  */

@Singleton
class FinatraDemoMongoDBController @Inject()(db: MongoClient) extends Controller {
  val underlyingGuavaCache = CacheBuilder.newBuilder().maximumSize(10000L).build[String, Object]
  implicit val scalaCache = ScalaCache(GuavaCache(underlyingGuavaCache))
  val cache = typed[String, NoSerialization]
  val pools = FuturePools.fixedPool("FinatraDemoMongoDBController", 200)
  get("/mongodb/random/async/:coll") {
    request: Request => {
      val index = Random.nextInt(100)
      caching(index.toString) {
        Future {
          val collName = request.getParam("coll")
          val col = db("hinews_test")(collName)
          val data = col.find(MongoDBObject()).take(100).toSeq
          data(index)
        }
      }
    }
  }

  get("/mongodb/random/sync/:coll") {
    request: Request => {
      val index = Random.nextInt(100)
      val cacheKey = index.toString
      sync.caching(cacheKey) {
        val collName = request.getParam("coll")
        val col = db("hinews_test")(collName)
        val data = col.find(MongoDBObject()).take(100).toSeq
        data(index)
      }
    }
  }
}
