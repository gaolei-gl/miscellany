package com.lei.util

object Utils {
  def timeIt[T](msg: String)(f: => T): T = {
    val t1 = System.currentTimeMillis()
    val r = f
    val elapse = (System.currentTimeMillis() - t1)
    println(s"${msg} costs ${elapse} ms.")
    r
  }

}
