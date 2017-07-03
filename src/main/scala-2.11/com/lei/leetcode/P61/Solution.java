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
        rotateRight(head, 99);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;

        int length = length(head);
        ListNode rotatedHead = rotate(head);
        int kk = k;
        if (k > length) {
            int turn = (k / length) % 2;
            kk = k % length;
            if (turn == 0)
                rotatedHead = rotate(head);
        }
        ListNode firstPart = rotatedHead, secondPart = null, pre = rotatedHead;

        for (int i = 0; i < kk; i++) {
            pre = rotatedHead;
            rotatedHead = rotatedHead.next;
        }
        secondPart = rotatedHead;
        pre.next = null;

        return merge(rotate(firstPart), rotate(secondPart));
    }

    private static ListNode rotate(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static int length(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    private static ListNode merge(ListNode a, ListNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        ListNode head = a;
        while (a.next != null) {
            a = a.next;
        }
        a.next = b;
        return head;
    }
}
