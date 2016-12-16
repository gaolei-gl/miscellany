package com.lei.future

import com.twitter.util.Future

/**
  * Created by Lei on 2016/12/13.
  */
object TwitterFuture {
  def main(args: Array[String]): Unit = {
    val f = Future {
      Thread.sleep(5 * 1000)
    }
  }
}
