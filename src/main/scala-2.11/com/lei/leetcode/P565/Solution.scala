package com.lei.leetcode.P565

object Solution {
  def arrayNesting(nums: Array[Int]): Int = {
    val len = nums.length
    var max = 0
    val set = collection.mutable.Set.empty[Int]
    for (i <- 0 until len) {
      var index = i
      var size = 0
      while (!set.contains(index)) {
        set.add(index)
        index = nums(index)
        size += 1
      }
      max = Math.max(max, size)
    }
    max
  }


  def main(args: Array[String]): Unit = {
    val arr = Array(5, 4, 0, 3, 1, 6, 2)
    println(arrayNesting(arr))
  }

}
