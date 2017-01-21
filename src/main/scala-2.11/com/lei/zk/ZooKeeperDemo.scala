package com.lei.zk

import com.twitter.zk.ZkClient

import scala.language.postfixOps
import com.twitter.conversions.time._
import com.twitter.util.{Await, Future, Timer}
import scala.language.postfixOps

/**
  * Created by lei on 17-1-21.
  */
object ZooKeeperDemo {
  def main(args: Array[String]): Unit = {
    implicit val timer = com.twitter.util.Timer.Nil
    val client = ZkClient("localhost:2181", 10 seconds).withRetries(3)
    //    client("/test").exists.watch() onSuccess (println)
    client("/test").getData()

    Await.ready(Future.never)
  }

}

