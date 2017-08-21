//package com.lei.leetcode.P621
//
//object Solution {
//  def main(args: Array[String]): Unit = {
//    val a = Array('A', 'A', 'A', 'B', 'B', 'B')
//    println(leastInterval(a, 2))
//  }
//
//  def leastInterval(tasks: Array[Char], n: Int): Int = {
//    val elements = tasks.groupBy(identity).map(_._2.length).toVector
//    val a = for {
//      i <- 1 to elements.size
//      t = elements.map(_ - i).filter(_ > 0)
//    } yield n - t.size + 1
//    a.filter(_ > 0).sum + tasks.length
//  }
//}
