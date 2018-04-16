class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return str(self.val)


from pprint import pprint


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        if root is None:
            return
        ancestor = {root: None}
        self._buildFamilyTree(root, ancestor)
        pp = p
        l1 = []
        while pp is not None:
            l1.append(pp)
            pp = ancestor[pp]
        qq = q
        l2 = []
        while qq is not None:
            l2.append(qq)
            qq = ancestor[qq]

        l1.reverse()
        l2.reverse()
        l = min(len(l1), len(l2))
        i = 0
        while i < l and l1[i] == l2[i]:
            i += 1
        return l1[i - 1]

    def _buildFamilyTree(self, root, ancestor):
        if root is None:
            return
        if root.left is not None:
            ancestor[root.left] = root
            self._buildFamilyTree(root.left, ancestor)
        if root.right is not None:
            ancestor[root.right] = root
            self._buildFamilyTree(root.right, ancestor)


if __name__ == '__main__':
    root = TreeNode(3)
    n5 = TreeNode(5)
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n4 = TreeNode(4)
    n6 = TreeNode(6)
    n7 = TreeNode(7)
    n8 = TreeNode(8)
    n0 = TreeNode(0)

    root.left = n5
    root.right = n1
    n5.left = n6
    n5.right = n2
    n1.left = n0
    n1.right = n8
    n2.left = n7
    n2.right = n4

    s = Solution()
    nn1 = TreeNode(1)
    nn2 = TreeNode(2)
    nn1.left = nn2
    n = s.lowestCommonAncestor(root, n4 , n5)
    pprint(n)
