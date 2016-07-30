package com.lei.inheritance

/**
  * Created by Lei on 16/6/21.
  */
object Inheritance {
  def main(args: Array[String]) {
    val a = new Compent("com/lei")
    a.info("info")

    val seq = 1 to 10
    seq match {
      case head +: tail => println(s"this is $head and this is $tail")
    }

  }

}


trait Logger {
  def info(s: String): Unit

  def warn(s: String): Unit

  def fatal(s: String): Unit
}

trait ConsoleLogger {
  def info(s: String) = println("%s: %s".format("info", s))

  def warn(s: String) = println("%s: %s".format("warn", s))

  def fatal(s: String) = println("%s: %s".format("fatal", s))
}


class Compent(name: String) extends ConsoleLogger {
}
