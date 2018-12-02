# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        aggregator = []
        self.dfs(root, 0, aggregator)
        return sum(aggregator)

    def dfs(self, root, prefix, path):
        if root is None:
            return
        if root.left is None and root.right is None:
            path.append(prefix * 10 + root.val)
        if root.left is not None:
            self.dfs(root.left, prefix * 10 + root.val, path)
        if root.right is not None:
            self.dfs(root.right, prefix * 10 + root.val, path)
