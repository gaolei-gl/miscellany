# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def tree2str(self, t):
        if t is None:
            return ''
        val = str(t.val)
        if t.left is None and t.right is None:
            return val
        elif t.left is not None and t.right is None:
            return val + '(' + self.tree2str(t.left) + ')'
        else:
            return val + '(' + self.tree2str(t.left) + ')(' + self.tree2str(t.right) + ')'
