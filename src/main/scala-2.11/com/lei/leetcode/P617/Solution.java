package com.lei.leetcode.P617;

import com.lei.leetcode.TreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other.
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode head = merge(t1, t2);
        return head;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);
        return t1;
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode node = new TreeNode(0);
        if (t1 != null && t2 != null) {
            node.val = t1.val + t2.val;
            node.left = merge(t1.left, t2.left);
            node.right = merge(t1.right, t2.right);
        } else if (t1 != null) {
            node.val = t1.val;
            node.left = t1.left;
            node.right = t1.right;
        } else {
            node.val = t2.val;
            node.left = t2.left;
            node.right = t2.right;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(1);
        t1.left.right = new TreeNode(4);
        t1.right = new TreeNode(3);
        t1.right.right = new TreeNode(7);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(2);
        t2.left.left = new TreeNode(5);
        Solution s = new Solution();
        s.mergeTrees(t1, t2);
        System.out.println();
    }
}
