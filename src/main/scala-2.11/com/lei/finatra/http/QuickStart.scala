package com.lei.finatra.http

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.{Controller, HttpServer}
import com.twitter.util.Future

/**
  * Created by Lei on 16/8/27.
  */

object MyServerMain extends MyServer

class MyServer extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add[MyController]
  }
}

class MyController extends Controller {
  get("/", name = "root") {
    request: Request =>
      Future {
        "Hello world"
      }
  }
}

