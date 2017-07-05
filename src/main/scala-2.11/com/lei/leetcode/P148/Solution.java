package com.lei.leetcode.P148;

import com.lei.leetcode.ListNode;

import static com.lei.leetcode.ListNodeUtils.length;

/**
 * Created by Lei on 2017/7/5.
 */
public class Solution {

    static public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head, slow = head, pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

//        fast = slow;
//        slow = slow.next;
//        fast.next = null;
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }


    static private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                p.next = l2;
                l2 = l2.next;

            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4), p;
        head.next = new ListNode(3);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(7);
        p = sortList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
