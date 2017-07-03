package com.lei.leetcode.P83;

import java.util.HashSet;

/**
 * Created by lei on 17-7-3.
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head, p = head;
        HashSet<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.val)) {
                pre.next = head.next;
                head = head.next;
            } else {
                set.add(head.val);
                pre = head;
                head = head.next;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode p = deleteDuplicates(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
