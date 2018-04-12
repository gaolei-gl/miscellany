package com.lei.leetcode.P102

import com.lei.leetcode.P101

import scala.collection.mutable

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: P101.TreeNode = null
  var right: P101.TreeNode = null
}

object Solution {
  def levelOrder(root: P101.TreeNode): List[List[Int]] = {
    var result = List.empty[List[Int]]
    val queue = mutable.Queue.empty[P101.TreeNode]
    if (root == null) result
    else {
      queue.enqueue(root)
      while (queue.nonEmpty) {
        val nodes = queue.dequeueAll(_ => true)
        result ::= nodes.map(_.value).toList
        nodes.foreach { node =>
          if (node.left != null) queue.enqueue(node.left)
          if (node.right != null) queue.enqueue(node.right)
        }
      }
      result.reverse
    }

  }
  def main(args: Array[String]): Unit = {}
}
