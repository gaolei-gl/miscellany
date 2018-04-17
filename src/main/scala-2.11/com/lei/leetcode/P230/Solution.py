class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return str(self.val)


class Solution(object):
    l = []

    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.n = k
        self.pre(root)
        return self.l[-1]

    def pre(self, root):
        if root is None:
            return
        self.pre(root.left)
        if self.n == 0:
            return
        self.l.append(root.val)
        self.n -= 1
        if self.n == 0:
            return
        self.pre(root.right)
        if self.n == 0:
            return


if __name__ == '__main__':
    s = Solution()
    root = TreeNode(5)
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n4 = TreeNode(4)
    n6 = TreeNode(6)
    n7 = TreeNode(7)

    root.left = n2
    root.right = n6
    n6.right = n7
    n2.left = n1
    n2.right = n3
    n3.right = n4

print s.kthSmallest(root, 6)
