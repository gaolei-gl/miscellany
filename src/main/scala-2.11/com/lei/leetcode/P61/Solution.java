package com.lei.leetcode.P61;

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
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        rotateRight(head, 4);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null)
            return null;
        int length = len(head);
        ListNode tail = findTail(head);
        if (k > length)
            k = k % length;
        tail.next = head;
        for (int i = 0; i < k; i++)
            tail = tail.next;
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;

    }


    private static ListNode findTail(ListNode h) {
        if (h == null)
            return h;
        while (h.next != null)
            h = h.next;
        return h;
    }

    private static int len(ListNode h) {
        int l = 0;
        while (h != null) {
            l++;
            h = h.next;
        }
        return l;
    }

}
