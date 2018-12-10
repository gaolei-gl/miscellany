package com.lei.leetcode.P218

import java.util.{Collections, Comparator, PriorityQueue}

import scala.collection.mutable.ListBuffer


case class Point(x: Int, height: Int, isStart: Boolean) extends Comparable[Point] {
  override def compareTo(o: Point): Int = if (this.x != o.x) this.x - o.x
  else {
    (this.isStart, o.isStart) match {
      case (true, true) => o.height - this.height
      case (false, false) => this.height - o.height
      case (false, true) => 1
      case (true, false) => -1
    }
  }
}

object Solution {
  def getSkyline(buildings: Array[Array[Int]]): List[Array[Int]] = {
    val points = buildings.flatMap(arr => Seq(Point(arr(0), arr(2), true), Point(arr(1), arr(2), false))).sorted
    val queue = new PriorityQueue[Int](new Comparator[Int] {
      override def compare(o1: Int, o2: Int): Int = o2 - o1
    })
    queue.add(0)
    val buff = ListBuffer[Array[Int]]()
    var maxHeight = 0
    for (point <- points) {
      point.isStart match {
        case true => queue.add(point.height)
        case false => queue.remove(point.height)
      }
      val currentHeight = queue.peek()
      if (currentHeight != maxHeight) {
        buff += Array(point.x, currentHeight)
        maxHeight = currentHeight
      }
    }
    buff.toList
  }

  def main(args: Array[String]): Unit = {
    getSkyline(Array(Array(0, 2, 3), Array(2, 5, 3))).foreach(_.foreach(x => print(x + " ")))
  }
}

