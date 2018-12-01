package com.lei.leetcode.P234;

import com.lei.leetcode.ListNode;

import java.util.ArrayList;

/**
 * Created by Lei on 2017/7/3.
 */

public class Solution {
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>(500);
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }

        int length = array.size();
        for (int i = 0; i <= length / 2; i++) {
            if (array.get(i).intValue() != array.get(length - i - 1).intValue())
                return false;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        while (slow != null && head != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }


    private static ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode next, pre = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(isPalindrome2(head));
    }
}

