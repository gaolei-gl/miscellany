package com.lei.leetcode.P628

/**
  * Created by Lei on 2017/7/13.
  */
object Solution extends App {
  def maximumProduct(nums: Array[Int]): Int = {
    val a = nums.sorted
    val sum1 = a.takeRight(3).product
    val sum2 = a.last * a.take(2).product
    if (sum1 > sum2) sum1 else sum2
  }

  val array = Array(-4, -2, -3, -1, 60)
  maximumProduct(array)
}
