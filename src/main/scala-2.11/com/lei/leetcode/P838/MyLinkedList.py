class Node(object):

    def __init__(self, val):
        self.val = val
        self.next = None


class MyLinkedList(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = None
        self.tail = None
        self.size = 0

    def get(self, index):
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        :type index: int
        :rtype: int
        """
        if self.head is None or index >= self.size:
            return -1

        current = self.head
        for i in xrange(index):
            current = current.next
        return current.val

    def addAtHead(self, val):
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        :type val: int
        :rtype: void
        """
        if not self.head:
            self.head = Node(val)
            self.tail = self.head
        else:
            new_node = Node(val)
            new_node.next = self.head
            self.head = new_node
        self.size += 1

    def addAtTail(self, val):
        """
        Append a node of value val to the last element of the linked list.
        :type val: int
        :rtype: void
        """
        if not self.head:
            self.head = Node(val)
            self.tail = self.head
        else:
            new_node = Node(val)
            self.tail.next = new_node
            self.tail = new_node
        self.size += 1

    def addAtIndex(self, index, val):
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        :type index: int
        :type val: int
        :rtype: void
        """
        if index > self.size:
            return
        if index == 0:
            self.addAtHead(val)
        else:
            current = self.head
            for i in xrange(index - 1):
                current = current.next
            new_node = Node(val)
            new_node.next = current.next
            current.next = new_node
            if new_node.next is None:
                self.tail = new_node
            self.size += 1

    def deleteAtIndex(self, index):
        """
        Delete the index-th node in the linked list, if the index is valid.
        :type index: int
        :rtype: void
        """
        if not self.head or index >= self.size:
            return -1

        if index == 0:
            self.head = self.head.next
            if not self.head:
                self.tail = None

        else:
            current = self.head
            for i in xrange(index - 1):
                if current.next is None:
                    return
                current = current.next
            current.next = current.next.next
            if current.next is None:
                self.tail = current
        self.size -= 1
