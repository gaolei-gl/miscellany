package com.lei.leetcode.P71

import scala.collection.immutable.Stack

/**
  * Given an absolute path for a file (Unix-style), simplify it.
  * For example,
  * path = "/home/", => "/home"
  * path = "/a/./b/../../c/", => "/c"
  *
  */

object Solution {

  def simplifyPath(path: String): String = {
    val elements = path.split("/").filter(_ != "")
    var stack = Stack[String]()
    elements.foreach {
      e =>
        e match {
          case "." =>
          case ".." if stack.size == 0 =>
          case ".." => stack = stack.pop
          case s: String => stack = stack.push(s)
        }
    }
    "/" + stack.reverse.mkString("/")
  }

  def main(args: Array[String]): Unit = {
    val path = "/a/./b/.././c/"
    println(simplifyPath(path))
  }
}
