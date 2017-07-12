package com.lei.leetcode.P19;

import com.lei.leetcode.ListNode;

/**
 * Created by Lei on 2017/7/12.
 */
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy, slow = dummy;
        slow.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        removeNthFromEnd(head, 1);
    }
}
