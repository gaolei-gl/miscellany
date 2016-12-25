package com.lei.finagle

import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import com.xiaotunza.thrift.EchoService

/**
  * Created by Lei on 2016/12/23.
  */
object EchoServerClient {
  def main(args: Array[String]): Unit = {
    val t1 = System.currentTimeMillis()
    val client = Thrift.client.newIface[EchoService.FutureIface]("localhost:8080", "echo-service-client")
    val t2 = System.currentTimeMillis()
    val f = 1 to 5000 map {
      _ => client.echo("")
    }
    f.foreach(_ onSuccess (println))
    Await.ready(Future.join(f))
    val t3 = System.currentTimeMillis()
    val cntFuture = client.getCnt()
    val cnt = Await.result(cntFuture)
    println(s"all finished:\t ${t2 - t1} \t${t3 - t2}")
    println(cnt)

  }
}
