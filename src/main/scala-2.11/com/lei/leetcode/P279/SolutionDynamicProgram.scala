package com.lei.leetcode.P279

import java.util
import math.min

// 586 / 586 test cases passed.
//Status: Accepted
//Runtime: 556 ms
object SolutionDynamicProgram {
  def main(args: Array[String]): Unit = {
    println(numSquares(12))
  }

  def numSquares(n: Int): Int = {
    val cnt = new util.ArrayList[Int]()
    cnt.add(0)
    while (cnt.size() <= n) {
      val i = cnt.size()
      var j = 1
      var tmp = Int.MaxValue
      while (j * j <= i) {
        tmp = min(tmp, cnt.get(i - j * j) + 1)
        j += 1
      }
      cnt.add(tmp)
    }
    cnt.get(n)
  }


}
