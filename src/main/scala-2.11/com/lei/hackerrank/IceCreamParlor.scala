package com.lei.hackerrank

object IceCreamParlor {
  val reader = scala.io.StdIn

  def main(args: Array[String]): Unit = {
    val t = reader.readInt()
    for (_ <- 1 to t) {
      val m = reader.readInt()
      val n = reader.readInt()
      val line = reader.readLine()
      val arr = line.split(" ").map(_.toInt)
      val resp = for {
        i <- 0 until n
        j <- i + 1 until n
        if (arr(j) + arr(i) == m)
      } yield (i, j)

      val r = resp.head
      println(s"${r._1 + 1} ${r._2 + 1}")

    }
  }

}
