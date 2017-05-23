package com.lei.logback

/**
  * Created by Lei on 2017/5/4.
  */
object LogbackMain {
  def main(args: Array[String]): Unit = {
    val l1 = new Logback1
    val l2 = new Logback2

    l1.log
    l2.log

  }

}

