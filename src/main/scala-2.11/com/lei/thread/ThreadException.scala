package com.lei.thread

/**
  * Created by Lei on 2017/1/13.
  */
object ThreadException {
  def main(args: Array[String]): Unit = {
    def a = {
      println("abc")
      3 / 0
      println("cba")
    }

    val task = new ThrowableTask(a)
    val taskThread = new Thread(task)
    taskThread.start()
    Thread.sleep(2000)
    println("Do not affect main thread.")
    task.reThrow()
  }
}

class ThrowableTask(f: => Unit) extends Runnable {
  println("init task")
  private var t: Throwable = _

  override def run(): Unit = {
    try {
      Thread.sleep(100)
      println("before ")
      f
      println("after")
    }
    catch {
      case tt: Throwable =>
        println("出错啦")
        t = tt
    }
  }

  def reThrow() = if (t == null) println("empty") else println("we have something" + t)
}
