package com.lei.leetcode.P114;

import com.lei.leetcode.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode right = root.right;
        root.right = helper(root.left);
        TreeNode t = root;
        while (t.right != null) {
            t = t.right;
        }
        t.right = helper(right);
        root.left = null;
        return root;
    }
}
