package com.lei.finatra.http.controller

import java.util.concurrent.TimeUnit
import javax.inject.{Inject, Singleton}

import com.google.common.cache.CacheBuilder
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.utils.FuturePools

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.Random
import scalacache.{NoSerialization, ScalaCache, typed}
import scalacache.guava.GuavaCache
import scalacache._

//import com.twitter.conversions.time._


/**
  * Created by Lei on 2017/1/2.
  */

@Singleton
class FinatraDemoMongoDBController @Inject()(db: MongoClient) extends Controller {
  val underlyingGuavaCache = CacheBuilder.newBuilder().recordStats().maximumSize(10000L).build[String, Object]
  implicit val scalaCache = ScalaCache(GuavaCache(underlyingGuavaCache))
  val cache = typed[String, NoSerialization]
  val pools = FuturePools.fixedPool("FinatraDemoMongoDBController", 200)
  get("/mongodb/random/async/:coll") {
    request: Request => {
      val index = Random.nextInt(5000)
      caching(index.toString) {
        Future {
          val collName = request.getParam("coll")
          val col = db("hinews")(collName)
          val data = col.find(MongoDBObject()).take(500).toSeq
          data(index)
        }
      }
    }
  }

  get("/mongodb/random/sync/:coll") {
    request: Request => {
      val index = Random.nextInt(5000)
      val cacheKey = index.toString
      sync.caching(cacheKey) {
        val collName = request.getParam("coll")
        val col = db("hinews")(collName)
        val data = col.find(MongoDBObject()).take(500).toSeq
        data(index)
      }
    }
  }
  get("/mongodb/:id") {
    request: Request => {
      val a = cache.sync.get(request.getIntParam("id").toString)
      println(a)
      a
    }
  }
  get("/mongodb/fill/:id") {
    request: Request =>
      val index = request.getParam("id")
      println(index)
      sync.caching(index) {
        val col = db("hinews")("article")
        val data = col.find(MongoDBObject()).take(500).toSeq
        data(index.toInt)
      }
  }

  get("/mongodb/fillwithttl/:id") {
    request: Request =>
      val index = request.getParam("id")
      println(index)
      cachingWithTTL(index)(Duration(10, TimeUnit.SECONDS)) {
        Future {
          val col = db("hinews")("article")
          val data = col.find(MongoDBObject()).take(500).toSeq
          data(index.toInt)
        }
      }
  }
  get("/dump") {
    request: Request =>
      underlyingGuavaCache.size()
  }
  get("/mongodb/stats") {
    request: Request =>
      underlyingGuavaCache.stats()
  }
}
