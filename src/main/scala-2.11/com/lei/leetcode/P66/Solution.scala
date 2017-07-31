package com.lei.leetcode.P66

/**
  * Created by Lei on 2017/7/26.
  */

object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    def plus(digits:Array[Int], index:Int):Unit = {
      digits(index) += 1
      digits(index) match {
        case x:Int if(x >= 10) =>
          digits(index) = x % 10
          plus(digits, index - 1)
        case _ => digits(index)
      }
    }
    val d = 0 +: digits
    plus(d, digits.length)
    if(d(0) == 0) d.tail
    else d
  }
}

