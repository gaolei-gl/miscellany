package com.lei.leetcode.P965;

import com.lei.leetcode.TreeNode;

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return helper(root.left, val) && helper(root.right, val);
    }
}
