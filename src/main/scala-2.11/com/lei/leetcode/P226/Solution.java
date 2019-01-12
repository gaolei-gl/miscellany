package com.lei.leetcode.P226;

import com.lei.leetcode.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode t = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(t);
        return root;
    }
}
