package com.lei.thread

import java.util.concurrent.Executors

/**
  * Created by com.lei on 16-2-28.
  */
object CheckThreadOnLinux {
  def main(args: Array[String]) {
    val pool = Executors.newFixedThreadPool(100)
    for (i <- 0 to 200)
      pool.execute(makeItRun(fun))

  }

  def makeItRun(f: => Unit): Runnable = {
    new Runnable {
      override def run(): Unit = f
    }
  }

  def fun() {
    Thread.sleep(100000000)
  }
}
