package com.lei.leetcode.P109;

import com.lei.leetcode.ListNode;
import com.lei.leetcode.TreeNode;


/**
 * Created by lei on 17-7-9.
 */
public class Solution {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public static TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode t = new TreeNode(slow.val);
        t.left = toBST(head, slow);
        t.right = toBST(slow.next, tail);
        return t;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        TreeNode t = sortedListToBST(head);
        display(t);
    }

    public static void display(TreeNode t) {
        if (t == null) return;
        System.out.println(t.val);
        if (t.left != null) display(t.left);
        if (t.right != null) display(t.right);
    }
}
