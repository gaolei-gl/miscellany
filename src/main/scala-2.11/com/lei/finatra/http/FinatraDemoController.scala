package com.lei.finatra.http

import javax.inject.Inject

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import UserContext._
import com.twitter.finatra.request.QueryParam
import com.twitter.finatra.validation.{Max, NotEmpty, Size, UUID}

/**
  * Created by Lei on 2016/12/30.
  */
class FinatraDemoController extends Controller {
  get("/ping") { request: Request =>
    error("Do something before server start.")
    info("Do something before server start.")
    "pong"
  }

  get("/user/:id") { request: Request =>
    "Hi" + request.user.id
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
