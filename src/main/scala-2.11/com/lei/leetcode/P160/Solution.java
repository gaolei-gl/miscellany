package com.lei.leetcode.P160;

/**
 * Created by Lei on 2017/7/3.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode l2 = l1;
        System.out.println(getIntersectionNode(l1, l2));
    }
}
