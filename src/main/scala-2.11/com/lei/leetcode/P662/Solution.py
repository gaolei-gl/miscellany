# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def widthOfBinaryTree(self, root):
        if root is None:
            return 0
        queue = [root]
        setattr(root, 'seq', 1)
        max_width = 0
        while len(queue) != 0:
            q = queue[:]
            if len(queue) == 1:
                max_width = max(1, max_width)
            else:
                max_width = max(getattr(queue[-1], 'seq') - getattr(queue[0], 'seq') + 1, max_width)
            queue = []
            for node in q:
                seq = getattr(node, 'seq')
                if node.left is not None:
                    setattr(node.left, 'seq', seq * 2)
                    queue.append(node.left)
                if node.right is not None:
                    setattr(node.right, 'seq', seq * 2 + 1)
                    queue.append(node.right)
        return max_width


if __name__ == '__main__':
    s = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.left.left = TreeNode(8)
    root.right.right = TreeNode(7)
    root.right.right.right = TreeNode(15)
    print s.widthOfBinaryTree(root)
