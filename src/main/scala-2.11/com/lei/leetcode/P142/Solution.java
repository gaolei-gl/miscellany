package com.lei.leetcode.P142;

import com.lei.leetcode.ListNode;

/**
 * Created by lei on 17-7-9.
 */
public class Solution {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = fast;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == slow) return pre;
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode p = detectCycle(head);
        if (p != null) System.out.println(p.val);
    }
}
