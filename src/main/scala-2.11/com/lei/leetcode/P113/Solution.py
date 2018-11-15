# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

import copy


class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """

        result = []
        self.dfs(root, sum, [], result)
        return result

    def dfs(self, root, target, prefix, result):
        if root is None:
            return
        prefix.append(root.val)
        if sum(prefix) == target and root.left is None and root.right is None:
            result.append(copy.deepcopy(prefix))

        self.dfs(root.left, target, prefix, result)
        self.dfs(root.right, target, prefix, result)
        prefix.pop()
