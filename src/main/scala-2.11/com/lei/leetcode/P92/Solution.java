package com.lei.leetcode.P92;

import com.lei.leetcode.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        int i = 1;
        while (i < m) {
            i++;
            pre = head;
            head = head.next;
        }

        ListNode next = null;
        while (i < n) {
            i++;
            next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;

    }
}
