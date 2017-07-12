package com.lei.leetcode.P82;

import com.lei.leetcode.ListNode;

/**
 * Created by Lei on 2017/7/12.
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, s = head, f = head.next;
        while (f != null) {
            if (s.val == f.val) {
                while (f != null && f.val == s.val) {
                    s = s.next;
                    f = f.next;
                }
                pre.next = f;
                if (f == null)
                    break;
                f = f.next;
                s = s.next;
            } else {
                pre = s;
                f = f.next;
                s = s.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        deleteDuplicates(head);
    }
}
