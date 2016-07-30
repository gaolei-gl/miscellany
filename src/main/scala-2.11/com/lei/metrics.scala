package com.lei

import org.apache.commons.io.FileUtils
import scala.language.postfixOps

/**
  * Created by Lei on 16/6/21.
  */

case class Entry(id: Int, date: String, dur: Float)

object metrics {
  def main(args: Array[String]) {
    val lines = FileUtils.readLines(FileUtils.getFile("/Users/Lei/duration"), "utf-8")
    import collection.JavaConversions.asScalaBuffer
    val entries = lines.map { x =>
      val Array(id, date, dur) = x.split("\t")
      Entry(id.toInt, date, dur.toFloat)
    }
    //    val totalDuration = entries.groupBy(_.id).map {
    //      x =>
    //        (x._1, x._2.map(_.dur))
    //    }.map {
    //      x =>
    //        (x._1, x._2.sum)
    //    }.toSeq.sortBy(_._1).toMap


    val ids = entries.map(_.id).toSet.toList.par
    val days = entries.map(_.date).toSet.toList

    val result = for {
      id <- ids
      thisUser = entries.filter(_.id == id)
      total = thisUser.map(_.dur).sum

      divideByDay = for {
        day <- days
        todayReadDurationList = thisUser.filter(_.date == day)
        actualDuration = if (todayReadDurationList.isEmpty) 0 else todayReadDurationList.map(_.dur).sum
      } yield actualDuration
      s = "%s,%s,%s".format(id, total, divideByDay.mkString(","))
    } yield s

    FileUtils.writeStringToFile(FileUtils.getFile("/Users/Lei/output.csv"), result.mkString("\n"), "utf-8")

  }

  def sort(t1: (String, Float), t2: (String, Float)) = {
    val Array(id1, d1) = t1._1.split(" ")
    val Array(id2, d2) = t2._1.split(" ")
    val result = if (id1.toInt > id2.toInt)
      false
    else if (id1.toInt < id2.toInt)
      true
    else {
      if (d1 <= d2)
        true
      else
        false
    }
    result
  }


}
