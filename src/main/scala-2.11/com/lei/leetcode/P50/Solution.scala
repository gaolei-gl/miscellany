package com.lei.leetcode.P50

object Solution {
  def myPow(x: Double, n: Int): Double = {
    val (xx, nn) = reform(x, n)

    def _myPow(formatX: Double, formatN: Int): Double = {
      if (formatN == 0) 1.0
      else if (formatX < 0.00000001) 0.0
      else {
        if (formatN % 2 == 0) myPow(formatX * formatX, formatN / 2) else formatX * myPow(formatX * formatX, formatN / 2)
      }
    }

    _myPow(xx, nn)

  }


  def reform(x: Double, n: Int) = {
    if (n < 0 && n == Int.MinValue) {
      (1 / x, n - 1)
    }
    else if (n < 0) {
      (1 / x, -1 * n)
    }
    else (x, n)
  }

  def main(args: Array[String]): Unit = {
    var x = 2.00000
    var n = -2147483648
    println(myPow(x, n))
    x = 2
    n = -2
    println(myPow(x, n))
  }
}
