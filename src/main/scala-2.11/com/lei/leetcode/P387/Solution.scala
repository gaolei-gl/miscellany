package com.lei.leetcode.P387

object Solution {

  case class OrderedCounter(index: Int, cnt: Int)

  val s = "loveleetcode"


  def firstUniqChar(str: String): Int = {
    val m = new collection.mutable.HashMap[Char, OrderedCounter]
    for ((ch, idx) <- str.zipWithIndex) {
      val elem = m.getOrElseUpdate(ch, OrderedCounter(idx, 0))
      val newElem = elem.copy(cnt = elem.cnt + 1)
      m.put(ch, newElem)
    }

    m.values.filter(_.cnt == 1).toSeq.sortBy(_.index).headOption.map(_.index).getOrElse(-1)
  }

  def main(args: Array[String]): Unit = {
    println(firstUniqChar(s))
  }

}
