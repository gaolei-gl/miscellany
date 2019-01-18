package com.lei.leetcode.P110;

import com.lei.leetcode.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean isBalanced2(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode r) {
        if (r == null) return 0;

        int left = dfsHeight(r.left);
        if (left == -1) return -1;
        int right = dfsHeight(r.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
