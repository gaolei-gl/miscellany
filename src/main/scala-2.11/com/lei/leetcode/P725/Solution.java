package com.lei.leetcode.P725;

import com.lei.leetcode.ListNode;

import java.util.List;

/*
Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1.
 This may lead to some parts being null.

The parts should be in order of occurrence in the input list,
 and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) return res;
        int length = size(root);
        if (length == 0) return res;
        int extra = length % k - 1;
        int fixSize = length / k;
        for (int i = 0; i < k; i++) {
            root = take(root, res, i, extra, fixSize);
        }
        return res;
    }


    private ListNode take(ListNode head, ListNode[] res, int idx, int extra, int fixSize) {
        ListNode p = head;
        if (head == null) return head;
        if (idx <= extra) fixSize += 1;
        int i = 0;
        while (++i < fixSize) p = p.next;
        res[idx] = head;
        head = p.next;
        p.next = null;
        return head;
    }

    private int size(ListNode root) {
        int i = 0;
        while (root != null) {
            i++;
            root = root.next;
        }
        return i;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        Solution s = new Solution();
        s.splitListToParts(n1, 3);
        System.out.println();
    }
}
