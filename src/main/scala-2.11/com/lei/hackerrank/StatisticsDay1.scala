package com.lei.hackerrank

// https://www.hackerrank.com/challenges/s10-standard-deviation/problem
object StatisticsDay1 {
  def main(args: Array[String]): Unit = {
    interquartile
  }


  def standDeviation: Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
     */
    val reader = scala.io.StdIn
    val N = reader.readInt
    val data = reader.readLine.split(" ").map(_.toInt)
    val mean = data.sum / (N + 0.0)
    val result = math.sqrt(data.map(n => math.pow(n - mean, 2)).sum / N)
    println(f"${result}%.1f")
  }

  def quartile(): Unit = {
    def median(d: Array[Int]) = {
      val len = d.length
      if (len % 2 == 0) {
        (d(len / 2 - 1) + d(len / 2)) / 2
      }
      else {
        d(len / 2)
      }

    }

    val reader = scala.io.StdIn
    val N = reader.readInt
    val data = reader.readLine.split(" ").map(_.toInt).sorted
    if (N % 2 == 0) {
      val q1 = median(data.take(N / 2))
      val q2 = median(data)
      val q3 = median(data.drop(N / 2))
      println(q1)
      println(q2)
      println(q3)
    } else {
      val q1 = median(data.take(N / 2))
      val q2 = median(data)
      val q3 = median(data.drop(N / 2 + 1))
      println(q1)
      println(q2)
      println(q3)
    }
  }

  def interquartile: Unit = {

    def median(d: Array[Int]) = {
      val len = d.length
      if (len % 2 == 0) {
        (d(len / 2 - 1) + d(len / 2) + 0.0) / 2
      }
      else {
        d(len / 2).toDouble
      }

    }

    val reader = scala.io.StdIn
    reader.readInt()
    val data = reader.readLine.split(" ").map(_.toInt)
    val frequency = reader.readLine.split(" ").map(_.toInt)
    val dataSet = data.zip(frequency).flatMap { case (n, times) => (0 until times).map(_ => n) }.sorted
    val size = dataSet.length
    if (size % 2 == 0) {
      val q1 = median(dataSet.take(size / 2))
      val q3 = median(dataSet.drop(size / 2))
      println(f"${q3 - q1}%.1f")
    }
    else {
      val q1 = median(dataSet.take(size / 2))
      val q3 = median(dataSet.drop(size / 2 + 1))
      println(f"${q3 - q1}%.1f")
    }
  }

}
