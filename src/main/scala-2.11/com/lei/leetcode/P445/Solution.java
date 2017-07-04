package com.lei.leetcode.P445;

import com.lei.leetcode.ListNode;

import static com.lei.leetcode.ListNodeUtils.length;
import static com.lei.leetcode.ListNodeUtils.reverse;

/**
 * Created by Lei on 2017/7/4.
 */


class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l = addTwoNumbers(l1, l2);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len2 > len1) {
            ListNode s = l1;
            l1 = l2;
            l2 = s;
        }
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        ListNode t1 = rl1;

        while (rl2 != null) {
            rl1.val += rl2.val;
            rl1 = rl1.next;
            rl2 = rl2.next;
        }
        rl1 = t1;
        while (rl1 != null) {
            if (rl1.val >= 10) {
                int consult = rl1.val / 10;
                if (rl1.next != null)
                    rl1.next.val += consult;
                else {
                    ListNode n = new ListNode(consult);
                    rl1.next = n;
                }
                rl1.val = rl1.val % 10;
            }
            rl1 = rl1.next;
        }
        return reverse(t1);

    }

}
