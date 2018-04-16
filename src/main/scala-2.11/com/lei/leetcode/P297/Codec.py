class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return str(self.val)


class Codec(object):
    def serialize(self, root):
        if root is None:
            return
        idx = 0
        order = {}
        self._traverse(root, idx, order)
        import cPickle
        return cPickle.dumps(order)

    def _traverse(self, node, idx, order):
        if node is None:
            return
        order[idx] = node.val
        self._traverse(node.left, 2 * idx + 1, order)
        self._traverse(node.right, 2 * idx + 2, order)

    def deserialize(self, data):
        if data is None:
            return

        import cPickle
        order = cPickle.loads(data)
        keys = order.keys()
        for k, v in order.iteritems():
            order[k] = TreeNode(v)

        for k in keys:
            order[k].left = order[2 * k + 1] if 2 * k + 1 in keys else None
            order[k].right = order[2 * k + 2] if 2 * k + 2 in keys else None
        return order[0]


class Codec2(object):
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            return ''
        l = [str(root.val) + 'x']
        nodes = self._travel([root])
        while len(filter(lambda x: x, nodes)) != 0:
            l.extend(map(lambda x: self._getval(x), nodes))
            nodes = self._travel(nodes)
        return ''.join(l)

    def _getval(self, node):
        if node is None:
            return '_x'
        return str(node.val) + 'x'

    def _travel(self, nodes):
        from itertools import chain
        if nodes is None:
            return
        c = [self._children(node) for node in nodes]
        return list(chain.from_iterable(c))

    def _children(self, node):
        if node is None:
            return None, None
        return node.left, node.right

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data == '':
            return None
        data = filter(lambda x: x != '', data.split("x"))
        nodes = map(lambda x: self._build_node(x), data)
        half = len(nodes) / 2
        for i in range(0, half):
            node = nodes[i]
            if node is not None:
                node.left = nodes[2 * i + 1]
                node.right = nodes[2 * i + 2]
        return nodes[0]

    def _build_node(self, val):
        if val != '_':
            return TreeNode(val)
        return None


if __name__ == '__main__':
    codec = Codec()
    # root = TreeNode(3)
    # n5 = TreeNode(5)
    # n1 = TreeNode(1)
    # n2 = TreeNode(2)
    # n4 = TreeNode(4)
    # n6 = TreeNode(6)
    # n7 = TreeNode(7)
    # n8 = TreeNode(8)
    # n0 = TreeNode(0)
    #
    # root.left = n5
    # root.right = n1
    # n5.left = n6
    # n5.right = n2
    # n1.left = n0
    # n1.right = n8
    # n2.left = n7
    # n2.right = n4
    codec2 = Codec2()
    import datetime

    root = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n4 = TreeNode(4)
    n5 = TreeNode(5)
    root.right = n2
    n2.right = n3
    n3.right = n4
    n4.right = n5

    start = datetime.datetime.now()
    n = codec.deserialize(codec.serialize(root))
    for i in range(1, 100):
        codec.serialize(n)
    print datetime.datetime.now() - start
    start = datetime.datetime.now()
    for i in range(1, 100):
        codec2.serialize(root)
    r = codec.deserialize(codec.serialize(root))
    print datetime.datetime.now() - start
