package com.lei.finatra.http

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.filters._
import com.twitter.finatra.http.{Controller, HttpServer}
import com.twitter.util.Future

/**
  * Created by Lei on 16/8/27.
  */

object FinatraDemoMain extends FinatraDemo

class FinatraDemo extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .filter[AccessLoggingFilter[Request]]
      .filter[StatsFilter[Request]]
      .add[FinatraDemoController]
  }
}

