package com.lei.leetcode.P222;

import com.lei.leetcode.TreeNode;


public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = height(root);
        return h - 1 == height(root.right) ? (1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
    }

    private int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + height(root.left);
    }


}
