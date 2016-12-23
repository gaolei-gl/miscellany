package com.lei.finagle

import com.twitter.finagle.{Service, Thrift}
import com.twitter.finagle.thrift.Protocols
import com.twitter.util.{Await, Future}
import com.xiaotunza.thrift._
import com.twitter.app.App


/**
  * Created by Lei on 2016/12/23.
  */
object EchoServerServer extends App {
  var count = 0
  val server: EchoService.FutureIface = new EchoService.FutureIface {
    override def echo(msg: String) = {
      count += 1
      Future.value(s"From server resp #${count}: ${msg}")
    }

    override def getCnt(): Future[Long] = Future.value(count)
  }
  val finagleServer: Service[Array[Byte], Array[Byte]] = new EchoService.FinagledService(server, Protocols.binaryFactory())

  def main(): Unit = {
    // thrift protocol without announcing
    val thriftServer = Thrift.server
      .withLabel("thrift-echo-service")
      .serve(":8080", finagleServer)

    Await.result(thriftServer)
  }

}
