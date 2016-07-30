package com.lei.finch

import io.finch._
import com.twitter.finagle.Http
import com.twitter.util.Await

/**
  * Created by Lei on 16/6/20.
  */


case class Locale(language: String, country: String)

case class Time(locale: Locale, time: String)


object QuickStart {
  def main(args: Array[String]) {

    val api: Endpoint[String] = get("hello") {
      Ok("adf")
    }
    Await.ready(Http.serve(":8080", api.toService))

  }
}
