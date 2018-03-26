package com.lei.leetcode.P300

import scala.collection.mutable.ListBuffer

object SearchSolution {
  def main(args: Array[String]): Unit = {
    //    val a = Array(10, 9, 2, 5, 3, 7, 101, 18)
    //    val a = Array(4, 4, 2, 5, 3, 7)
    val a = Array(10, 9, 2, 5, 3, 4)
    println(lengthOfLIS(a))
  }

  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else {
      val lis = ListBuffer[Int](nums.map(_ => 1): _*)
      for ((n, idx) <- nums.zipWithIndex) {
        var maxLength = 1
        var maxNum = n
        for (each <- nums.drop(idx + 1)) {
          if (maxNum < each) {
            maxNum = each
            maxLength += 1
          }
        }
        lis(idx) = maxLength
      }
      lis.max
    }
  }

}
