# Definition for binary tree with next pointer.
class TreeLinkNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


import itertools


class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if root is None:
            return
        nodes = self.nextLevel([root])
        while nodes is not None:
            self.do_connect(nodes)
            nodes = self.nextLevel(nodes)

    def nextLevel(self, nodes):
        """ get all the nodes in the next level"""
        if nodes is None or len(nodes) == 0:
            return None
        c = [(node.left, node.right) for node in nodes]
        return filter(lambda x: x is not None, list(itertools.chain.from_iterable(c)))

    def do_connect(self, nodes):
        """connect all the nodes horizontallly"""
        if nodes is None or len(nodes) == 0:
            return

        i = 0
        while i + 1 < len(nodes):
            nodes[i].next = nodes[i + 1]
            i += 1


if __name__ == '__main__':
    s = Solution()
    root = TreeLinkNode(1)
    root.left = TreeLinkNode(2)
    root.right = TreeLinkNode(3)
    root.left.left = TreeLinkNode(4)
    root.left.right = TreeLinkNode(5)
    root.right.left = TreeLinkNode(6)
    root.right.right = TreeLinkNode(7)
    s.connect(root)
