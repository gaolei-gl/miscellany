package com.lei.leetcode.P300

import scala.collection.mutable.ListBuffer

object Solution {
  def main(args: Array[String]): Unit = {
    val a = Array(4, 4, 2, 5, 3, 7)
    println(lengthOfLIS(a))
  }

  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else {
      val lis = ListBuffer(nums.map(_ => 1): _*)
      for ((n, idx) <- nums.zipWithIndex) {
        val a = lis.zip(nums).take(idx).filter(_._2 < n).map(_._1)
        val maxLength = if (a.isEmpty) 1 else a.max + 1
        lis(idx) = maxLength
      }
      lis.max
    }
  }
}
