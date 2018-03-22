package com.lei.leetcode.P279


/**
  * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
  * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
  */

// brutal strategy, not really worked.
// this algorithm is not only give the least number but also record the square number they need.
object BrutalSolution {
  def getSeq(n: Int) = {
    import math.sqrt
    val maxSquare = sqrt(n).toInt
    1 to maxSquare map (x => x * x)
  }


  def resolve(seq: Seq[Int], path: Seq[Int], aim: Int): Seq[Int] = {
    if (aim == 0) path
    else if (seq.length == 0) Nil
    else {
      val value = seq.head
      val times = aim / value
      val results = for {
        i <- 0 to times
      } yield resolve(seq.drop(1), path ++ Seq.fill(i)(value), aim - value * i)
      results.filterNot(_.size == 0).sortBy(_.size).headOption.getOrElse(Nil)
    }

  }


  def numSquares(n: Int): Int = {
    val seq = getSeq(n)
    val resp = resolve(seq, Seq.empty[Int], n)
    println(resp)
    resp.length
  }

  def main(args: Array[String]): Unit = {
    println(numSquares(359))
  }

}
