package com.lei.leetcode.P101

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
    if (root == null) true
    else isMirror(root.left, root.right)
  }

  def isMirror(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == null && root2 == null) true
    else if (root1 == null || root2 == null) false
    else {
      root1.value == root2.value && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left)
    }
  }
}
