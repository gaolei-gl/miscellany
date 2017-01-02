package com.lei.finatra.http.modules


import javax.inject.Singleton

import com.google.inject.Provides
import com.mongodb.casbah.MongoClient
import com.twitter.inject.TwitterModule
import com.twitter.inject.annotations.Flag

/**
  * Created by Lei on 2017/1/2.
  */
object MongoDBModule extends TwitterModule {

  override val modules = Seq(MongoDBConfigModule)

  @Singleton
  @Provides
  def provideMongoDBConnection(@Flag("mongo.host") host: String, @Flag("mongo.port") port: Int): MongoClient = {
    MongoClient(host, port)
  }

}
