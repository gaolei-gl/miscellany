package com.lei.finatra

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.{Controller, HttpServer}
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.util.Future

/**
  * Created by Lei on 16/8/27.
  */

object MyServerMain extends MyServer

class MyServer extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add[controller]
  }
}

class controller extends Controller {
  get("/", name = "root") {
    request: Request =>
      Future {
        "Hello world"
      }
  }
}

