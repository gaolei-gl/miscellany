package com.lei.finagle

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.{Await, Future}

/**
  * Created by Lei on 16/6/20.
  */
object QuickStart {
  def main(args: Array[String]) {
    //    val service = new Service[http.Request, http.Response] {
    //      def apply(req: http.Request): Future[http.Response] =
    //        Future.value(
    //          http.Response(req.version, http.Status.Ok)
    //        )
    //    }
    //    val server = Http.serve(":8080", service)
    //    Await.ready(server)

    val service = new Service[Request, Response] {
      override def apply(request: Request): Future[Response] = {
        Future {
          Response(http.Version.Http11, http.Status.Ok)
        }
      }
    }

    val server = Http.serve(":8080", service)
    Await.ready(server)

  }

}
