package com.lei.leetcode.P279

import scala.collection.mutable

// this is better, but still exceed time limitation.
object Solution1 {
  def getSeq(n: Int) = {
    import math.sqrt
    val maxSquare = sqrt(n).toInt
    maxSquare.to(1, -1) map (x => x * x)
  }

  val cache = mutable.HashMap[String, Int]()

  def resolve(seq: Seq[Int], aim: Int): Int = {
    val key = seq.toString() + aim
    if (seq.length <= 1) aim
    else if (!cache.contains(key)) {
      val head = seq.head
      val result = math.min(1 + resolve(seq.filter(_ <= aim - head), aim - head), resolve(seq.drop(1).filter(_ <= aim), aim))
      cache.put(key, result)
      result
    }
    else {
      cache.get(key).get
    }
  }


  def numSquares(n: Int): Int = {
    val seq = getSeq(n)
    resolve(seq, n)
  }

  def main(args: Array[String]): Unit = {
    val a = com.lei.util.Utils.timeIt("")(numSquares(359))
    println(a)
  }

}
