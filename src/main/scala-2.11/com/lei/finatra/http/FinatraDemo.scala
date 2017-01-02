package com.lei.finatra.http

import com.google.inject.Module
import com.lei.finatra.http.controller.{FinatraDemoController, FinatraDemoMongoDBController}
import com.lei.finatra.http.filter.FinatraDemoRequestScopeFilter
import com.lei.finatra.http.handler.FinatraDemoWarmupHandler
import com.twitter.finatra.http.routing.HttpRouter
import com.lei.finatra.http.modules._
import com.twitter.finatra.http.filters._
import com.twitter.finatra.http.{Controller, HttpServer}

/**
  * Created by Lei on 16/8/27.
  */

object FinatraDemoMain extends FinatraDemo

class FinatraDemo extends HttpServer {
  override val modules = Seq(
    MongoDBModule
  )

  protected override def failfastOnFlagsNotParsed: Boolean = true


  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .filter[FinatraDemoRequestScopeFilter]
      .add[FinatraDemoController]
      .add[FinatraDemoMongoDBController]
      .exceptionMapper[MalformedURLExceptionMapper]
  }


  override def warmup(): Unit = {
    handle[FinatraDemoWarmupHandler]
  }
}

