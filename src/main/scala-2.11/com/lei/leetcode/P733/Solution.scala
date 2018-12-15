package com.lei.leetcode.P733

import java.util

object Solution {
  def nextCoordinate(x: Int, y: Int) = Seq((x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1))

  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val X = image.length
    val Y = image(0).length
    val set = new util.HashSet[(Int, Int)]()
    val originColor = image(sr)(sc)
    val queue = new util.LinkedList[(Int, Int)]()

    def withInBoundary(coordinate: (Int, Int)) = coordinate._1 >= 0 && coordinate._1 < X && coordinate._2 >= 0 && coordinate._2 < Y

    def noDup(coordinate: (Int, Int)) = !set.contains(coordinate)

    def sameColor(coordinate: (Int, Int)) = image(coordinate._1)(coordinate._2) == originColor

    queue.add((sr, sc))

    while (!queue.isEmpty) {
      val (row, col) = queue.pollFirst()
      image(row)(col) = newColor
      nextCoordinate(row, col).filter(withInBoundary).filter(noDup).filter(sameColor).foreach { x =>
        set.add(x)
        queue.add(x)
      }
    }
    image
  }
}
