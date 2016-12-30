package com.lei.finagle

import com.twitter.finagle.{Service, Thrift}
import com.twitter.finagle.thrift.Protocols
import com.twitter.util.{Await, Future}
import com.twitter.app.App
import com.xiaotunza.thrift.EchoService


/**
  * Created by Lei on 2016/12/23.
  */
object EchoServerServer extends App {
  val slogan = flag[String]("slogan", "From server resp ", "slogan response from server")
  val server: EchoService.FutureIface = new EchoService.FutureIface {
    var count = 0

    override def echo(msg: String) = {
      this synchronized {
        count += 1
      }
      Future.value(s"${slogan()} #${count}: ${msg}")
    }

    override def getCnt(): Future[Long] = Future.value(count)
  }
  val finagleServer: Service[Array[Byte], Array[Byte]] = new EchoService.FinagledService(server, Protocols.binaryFactory())

  def main(): Unit = {
    // thrift protocol without announcing
    val thriftServer = Thrift.server
      .withLabel("thrift-echo-service")
      //      .withBufferedTransport() // compat for python
      .serve(":8080", finagleServer)

    closeOnExit(thriftServer)
    Await.result(thriftServer)
  }

}
