package com.lei.leetcode.P234;

import java.util.ArrayList;

/**
 * Created by Lei on 2017/7/3.
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

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

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(isPalindrome(head));
    }
}

