package com.lei.leetcode.P143;

import com.lei.leetcode.ListNode;
import com.lei.leetcode.ListNodeUtils;

/**
 * Created by lei on 17-7-9.
 */
public class Solution {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        // reverse last part pointer is fast.
        ListNode l2 = ListNodeUtils.reverse(fast);
        int i = 0;
        while (l2 != null && head != null) {
            if (i % 2 == 0) {
                dummy.next = head;
                head = head.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
            i++;
        }
        while (head != null) {
            dummy.next = head;
            head = head.next;
        }
        while (l2 != null) {
            dummy.next = l2;
            l2 = l2.next;
        }

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
