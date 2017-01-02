package com.lei.finatra.http

import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.filters._
import com.twitter.finatra.http.{Controller, HttpServer}

/**
  * Created by Lei on 16/8/27.
  */

object FinatraDemoMain extends FinatraDemo

class FinatraDemo extends HttpServer {
  protected override def failfastOnFlagsNotParsed: Boolean = true


  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .filter[FinatraDemoRequestScopeFilter]
      .add[FinatraDemoController]
      .exceptionMapper[MalformedURLExceptionMapper]
  }


  override def warmup(): Unit = {
    handle[FinatraDemoWarmupHandler]
  }
}

