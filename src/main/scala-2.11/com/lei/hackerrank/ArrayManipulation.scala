package com.lei.hackerrank

object ArrayManipulation {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val arr = Array.ofDim[Long](n)
    val m = sc.nextInt()
    var a0 = 0
    while (a0 < m) {
      val a = sc.nextInt()
      val b = sc.nextInt()
      val k = sc.nextInt()
      arr(a - 1) += k
      if (b < n) arr(b) -= k
      a0 += 1
    }
    var tmp, max = 0l
    for (i <- 0 until n) {
      tmp += arr(i)
      max = Math.max(tmp, max)
    }
    println(max)
  }

}
