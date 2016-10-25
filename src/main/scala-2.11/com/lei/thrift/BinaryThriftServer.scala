package com.lei.thrift

import java.nio.ByteBuffer

import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import com.xiaotunza.service.thrift.BinaryService


/**
  * Created by Lei on 16/9/27.
  */

object BinaryThriftServer {
  def main(args: Array[String]): Unit = {
    val server = Thrift.server.serveIface("localhost:9091", new BinaryServerImpl)
    Await.ready(server)
  }
}

class BinaryServerImpl extends BinaryService[Future] {
  override def add(a: Int, b: Int): Future[Int] = Future(a + b)
}
