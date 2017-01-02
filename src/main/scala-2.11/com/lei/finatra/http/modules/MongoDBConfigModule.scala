package com.lei.finatra.http.modules

import com.twitter.inject.TwitterModule

/**
  * Created by Lei on 2017/1/2.
  */
object MongoDBConfigModule extends TwitterModule {
  flag[String]("mongo.host", "localhost", "The host which hosting mongodb.")
  flag[Int]("mongo.port", 27017, "The port mongodb using.")
}
