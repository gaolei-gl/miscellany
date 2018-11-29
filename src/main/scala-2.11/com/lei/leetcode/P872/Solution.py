# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        order1 = []
        order2 = []
        self._traverse(root1, order1)
        self._traverse(root2, order2)
        return order1 == order2

    def _isLeaf(self, root):
        return root.left is None and root.right is None

    def _traverse(self, root, order):
        if root is None:
            return
        if self._isLeaf(root):
            order.append(root.val)
            return
        self._traverse(root.left, order)
        self._traverse(root.right, order)
