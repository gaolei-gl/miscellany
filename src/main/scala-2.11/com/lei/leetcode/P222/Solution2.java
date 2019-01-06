package com.lei.leetcode.P222;

import com.lei.leetcode.TreeNode;


public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root, right = root;
        int level = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            level++;
        }
        if (left == null) {
            return (1 << level) - 1;
        } else {
            return countNodes(root.right) + 1 + countNodes(root.left);
        }
    }


}
