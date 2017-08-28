package com.lei.hackerrank

object GreedyFlorist {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val c = new Array[Int](n)
    for (c_i <- 0 to n - 1) {
      c(c_i) = sc.nextInt()
    }

    val bucketCount = (n + 1) / k
    val sortedC = c.sorted.reverse.map(_.toLong)
    val s = for {
      i <- 0 to bucketCount
      j <- 0 until k
      if (i * k + j < n)
    } yield (i + 1) * sortedC(i * k + j)
    println(s.sum)
  }
}
