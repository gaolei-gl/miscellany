package com.lei.leetcode.P605

/**
  * Created by Lei on 2017/7/13.
  */
object Solution extends App {

  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    var index = 0
    var left = n
    val length = flowerbed.length
    while (index < length && left != 0) {
      if (flowerbed(index) == 0 && index == 0 && flowerbed(index + 1) == 0) {
        flowerbed(index) = 1
        left -= 1
      } else if (flowerbed(index) == 0 && flowerbed(index - 1) == 0 && index == length - 1) {
        flowerbed(index) = 1
        left -= 1
      } else if (flowerbed(index) == 0 && flowerbed(index - 1) == 0 && flowerbed(index + 1) == 0) {
        flowerbed(index) = 1
        left -= 1
      }
      index += 1
    }

    if (left == 0) true else false
  }

  val f = Array(1, 0, 0, 0, 1)

  println(canPlaceFlowers(f, 1))

}
