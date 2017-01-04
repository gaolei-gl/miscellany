package com.lei.finatra.http.modules

import javax.inject.Singleton

import com.google.inject.Provides
import com.mongodb.casbah.MongoClient
import com.twitter.inject.TwitterModule

/**
  * Created by Lei on 2017/1/2.
  */
object MongoDBModule extends TwitterModule {
  val host = flag[String]("mongo.host", "localhost", "The host which hosting mongodb.")
  val port = flag[Int]("mongo.port", 27017, "The port mongodb using.")

  @Singleton
  @Provides
  def provideDB = MongoClient(host(), port())
}
