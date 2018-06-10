package com.lei.hackerrank

object StatisticsDay0 {

  def solution1() = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val reader = scala.io.StdIn
    val N = reader.readInt()
    val data = reader.readLine.split(" ").map(_.toInt).sorted
    val mean = (data.sum + 0.0) / N
    val median = if (N % 2 == 0) (data(N / 2) + data(N / 2 - 1) + 0.0) / 2 else data(N / 2) + 0.0
    val cntMap = scala.collection.mutable.Map.empty[Int, Int]
    data.foreach { n => cntMap.put(n, cntMap.getOrElse(n, 0) + 1) }
    val sortedCntMap = cntMap.groupBy(_._2).map(x => (x._1, x._2.keys)).toSeq.sortBy(-_._1)
    val mode = sortedCntMap.head._2.toSeq.sortWith(_ < _).head
    println(mean)
    println(median)
    println(mode)
  }

  def solution2() = {
    val reader = scala.io.StdIn
    val N = reader.readInt()
    val data = reader.readLine.split(" ").map(_.toInt)
    val weights = reader.readLine().split(" ").map(_.toInt)
    val weightedSum = data.zip(weights).map(tuple => tuple._1 * tuple._2).sum + 0.0
    println(f"${weightedSum / weights.sum}%.1f")
  }

  def main(args: Array[String]) {
    solution2()

  }

}
