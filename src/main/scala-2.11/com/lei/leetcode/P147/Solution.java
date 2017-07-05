package com.lei.leetcode.P147;

import com.lei.leetcode.ListNode;

/**
 * Created by Lei on 2017/7/5.
 */
public class Solution {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head, end = head, cur = head, pre = dummy;

        while (p != null) {
            cur = dummy.next;
            pre = dummy;
            while (cur.val < p.val && cur != p) {
                pre = cur;
                cur = cur.next;
            }
            if (p == cur) {
                end = p;
                p = p.next;
            } else {
                ListNode next = p.next;
                p.next = cur;
                pre.next = p;
                p = next;
                end.next = next;
            }

        }
        end.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(1);
        ListNode p = insertionSortList(head);

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }

}
