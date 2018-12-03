# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return str(self.val)


class Solution(object):

    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        res = []
        level = []
        if root is None:
            return res
        level.append(root)
        while len(level) != 0:
            res.append(level[-1].val)
            end = len(level)
            for i in xrange(end):
                node = level[i]
                if node.left is not None:
                    level.append(node.left)
                if node.right is not None:
                    level.append(node.right)
            level = level[end:]
        return res


if __name__ == '__main__':
    s = Solution()
    root = TreeNode(1)
    two = TreeNode(2)
    root.left = two
    two.left = TreeNode(3)
    print s.rightSideView(root)
