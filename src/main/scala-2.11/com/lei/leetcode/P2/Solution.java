package com.lei.leetcode.P2;

import com.lei.leetcode.ListNode;
import com.lei.leetcode.ListNodeUtils;

/**
 * Created by Lei on 2017/7/12.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            p.next = new ListNode(l1.val);
            p = p.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            p.next = new ListNode(l2.val);
            p = p.next;
            l2 = l2.next;
        }

        p = dummy.next;
        while (p != null) {
            if (p.val > 9) {
                int v = p.val / 10;
                int vv = p.val % 10;
                p.val = vv;
                if (p.next != null) p.next.val += v;
                else {
                    p.next = new ListNode(v);
                }
            }
            p = p.next;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

    }
}
