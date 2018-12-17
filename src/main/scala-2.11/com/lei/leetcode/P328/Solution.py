# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None

        op_dummy = op = ListNode(0)
        ep_dummy = ep = ListNode(0)
        while head:
            op.next = head
            ep.next = head.next
            ep = ep.next
            op = op.next
            head = head.next.next if ep else None
        op.next = ep_dummy.next
        return op_dummy.next


# 1 2 3 4 5 6
# 1 2 3 4 5

if __name__ == '__main__':
    s = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    print s.oddEvenList(head)
