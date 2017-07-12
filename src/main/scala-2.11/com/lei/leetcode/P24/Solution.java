package com.lei.leetcode.P24;

import com.lei.leetcode.ListNode;

/**
 * Created by Lei on 2017/7/12.
 */
public class Solution {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, slow = head, fast = head.next;
        while (slow != null && fast != null) {
            slow.next = fast.next;
            fast.next = slow;
            pre.next = fast;
            pre = slow;
            slow = slow.next;
            if (slow == null) break;
            fast = slow.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        ListNode p = swapPairs(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
