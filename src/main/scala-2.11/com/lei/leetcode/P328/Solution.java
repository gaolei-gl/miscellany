package com.lei.leetcode.P328;

import com.lei.leetcode.ListNode;

/**
 * Created by Lei on 2017/7/7.
 */
public class Solution {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode op = odd, ep = even;
        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                op.next = head;
                op = op.next;
            } else {
                ep.next = head;
                ep = ep.next;
            }
            index++;
            head = head.next;
        }
        op.next = null;
        ep.next = null;

        op = odd;
        while (op.next != null) {
            op = op.next;
        }
        op.next = even.next;
        return odd.next;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode p = oddEvenList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
