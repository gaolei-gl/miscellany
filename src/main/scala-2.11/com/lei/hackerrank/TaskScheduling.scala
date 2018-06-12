package com.lei.hackerrank

import java.util.Comparator

import scala.collection.mutable.ArrayBuffer

// https://www.hackerrank.com/challenges/task-scheduling/problem

case class Task(deadline: Int, duration: Int, order: Int, scheduleDelay: Int)
    extends Ordering[Task] {
  override def compare(x: Task, y: Task): Int = {
    val xDelay = x.scheduleDelay + x.duration - x.deadline
    val yDelay = y.scheduleDelay + y.duration - y.deadline

    if (xDelay.compare(yDelay) == 0) {
      if (x.deadline.compare(y.deadline) == 0) {
        -x.duration.compare(y.duration)
      } else x.deadline.compare(y.deadline)
    } else -xDelay.compare(yDelay)
  }
}

object TaskScheduling {

  def taskScheduling(tasks: ArrayBuffer[Task]) = {
    val t = tasks.sort
    t.foreach{println}

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    val tasks = new scala.collection.mutable.ArrayBuffer[Task](t)
    for (tItr <- 1 to t) {
      val dm = stdin.readLine.split(" ")

      val d = dm(0).trim.toInt

      val m = dm(1).trim.toInt

      tasks += Task(d, m, 0, tItr, 0)
    }
    taskScheduling(tasks)

  }
}
