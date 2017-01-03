package com.lei.finatra.http.handler

import javax.inject.{Inject, Singleton}

import com.mongodb.casbah.MongoClient
import com.twitter.finatra.http.routing.HttpWarmup
import com.twitter.inject.utils.Handler

/**
  * Created by lei on 16-12-31.
  */

@Singleton
class FinatraDemoWarmupHandler @Inject()(httpWarmup: HttpWarmup) extends Handler {
  override def handle(): Unit = {
    //    httpWarmup.send(get("localhost:8000/"))
    //    httpWarmup.send(get("http://www.baidu.com"))
  }
}
