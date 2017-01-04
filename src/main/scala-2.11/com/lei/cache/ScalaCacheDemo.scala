package com.lei.cache

import scalacache._
import scalacache.guava._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import com.google.common.cache.CacheBuilder

/**
  * Created by Lei on 2017/1/3.
  */
object ScalaCacheDemo {

  def main(args: Array[String]): Unit = {
    val underlyingGuavaCache = CacheBuilder.newBuilder().maximumSize(10000L).build[String, Object]
    implicit val scalaCache = ScalaCache(GuavaCache(underlyingGuavaCache))
    val cache = typed[String, NoSerialization]
    put("custom key")("abc")
    val a = get[String, NoSerialization]("custom key")
    a onSuccess {
      case Some(str) => println(str)
      case _ => println("miss key")
    }

    val future: Future[String] = caching("myKey") {
      Future {
        "result of block"
      }
    }
    sync.get()
    Thread.sleep(5000)
    println(get[String, NoSerialization]("myKey").value)
    Thread.sleep(5000)

  }

}
