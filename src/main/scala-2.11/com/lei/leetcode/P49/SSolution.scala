package com.lei.leetcode.P49

object SSolution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.map(x => (x.sorted, x))
      .groupBy(_._1)
      .map(x => x._2.map(_._2).toList)
      .toList
  }

  def main(args: Array[String]): Unit = {
    println(groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
  }
}
