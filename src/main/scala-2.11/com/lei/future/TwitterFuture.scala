package com.lei.future

import com.twitter.util.{Await, Future, FuturePool, FuturePools}

//import concurrent.ExecutionContext.Implicits.global
//import concurrent.Future

/**
  * Created by Lei on 2016/12/13.
  */
object TwitterFuture {
  def main(args: Array[String]): Unit = {
    val pools = FuturePools.unboundedPool()
    val a = pools.apply(
      Future {
        Thread.sleep(5 * 1000)
      }
    )

    println(1)
    Await.ready(a)
  }
}
