package com.lei.zk

import com.twitter.zk.{ZNode, ZkClient}

import scala.language.postfixOps
import com.twitter.conversions.time._
import com.twitter.util.{Await, Future, Return, Timer}
import org.apache.zookeeper.data.Stat

import scala.language.postfixOps

/**
  * Created by lei on 17-1-21.
  */
object ZooKeeperDemo {
  def main(args: Array[String]): Unit = {
    implicit val timer = com.twitter.util.Timer.Nil
    val client = ZkClient("localhost:2181", 10 seconds).withRetries(3)
    val zNode = client("/test")
    //    Await.ready(zNode.setData("heihei".getBytes, 1))
    zNode.getData.watch() onSuccess {
      case ZNode.Watch(Return(z), u) => {
        u onSuccess {
          case x => println(x)
        }
        println("what" + new String(z.bytes))
      }
    }

//    val a = Await.result(zNode.getData())
//    println(new String(a.bytes))
    Await.ready(Future.never)

  }

}

