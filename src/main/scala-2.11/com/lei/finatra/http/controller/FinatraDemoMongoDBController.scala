package com.lei.finatra.http.controller

import javax.inject.{Inject, Singleton}

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import scala.util.Random

/**
  * Created by Lei on 2017/1/2.
  */

@Singleton
class FinatraDemoMongoDBController @Inject()(db: MongoClient) extends Controller {
  get("/mongodb/random/:coll") {
    request: Request => {
      val collName = request.getParam("coll")
      val col = db("hinews_test")(collName)
      val r = Random.shuffle(col.find(MongoDBObject()).take(100)).toList.head
      response.ok.json(r)
    }
  }
}
