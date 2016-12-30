package com.lei.finatra.http

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

/**
  * Created by Lei on 2016/12/30.
  */
class FinatraDemoController extends Controller {
  get("/ping") { request: Request =>
    "pong"
  }
}
