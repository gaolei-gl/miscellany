package com.lei.finatra.http.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.request.QueryParam
import com.twitter.finatra.validation.NotEmpty

/**
  * Created by Lei on 2016/12/30.
  */
class FinatraDemoController extends Controller {
  get("/ping") { request: Request =>
    "pong"
  }

  get("/user/:id") { request: Request =>
    "Hi" + request.getParam("id")
  }

  get("/bad/") { request: Request =>
    response.badRequest
  }
  get("/test") {
    test: Test =>
      println(test.request)
  }

}

case class Test(@NotEmpty @QueryParam name: String, request: Request)
