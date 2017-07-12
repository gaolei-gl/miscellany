package com.lei.leetcode.P86;

import com.lei.leetcode.ListNode;

/**
 * Created by Lei on 2017/7/10.
 */
public class Solution {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lt = new ListNode(-1);
        ListNode gte = new ListNode(-1);
        ListNode ltp = lt, gtep = gte;
        while (head != null) {
            if (head.val < x) {
                ltp.next = head;
                ltp = ltp.next;
            } else {
                gtep.next = head;
                gtep = gtep.next;
            }
            head = head.next;
        }
        ltp.next = gte.next;
        gtep.next = null;
        return lt.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
        ListNode p = partition(head, 3);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}
