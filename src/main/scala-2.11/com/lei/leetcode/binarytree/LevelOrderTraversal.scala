package com.lei.leetcode.binarytree

import scala.collection.mutable

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object LevelOrderTraversal {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    var result = List.empty[List[Int]]
    val queue = mutable.Queue.empty[TreeNode]
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
