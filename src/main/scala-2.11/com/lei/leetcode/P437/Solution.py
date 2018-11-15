class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """

        if root is None:
            return 0

        return self.nodeSum(root, sum, 0) + self.pathSum(root.left, sum) + self.pathSum(root.right, sum)

    def nodeSum(self, root, sum, current):
        total = 0
        if root is None:
            return total

        current += root.val
        if current == sum:
            total += 1

        total += self.nodeSum(root.left, sum, current)
        total += self.nodeSum(root.right, sum, current)

        return total
