package com.lei.leetcode.P337;

import com.lei.leetcode.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = new int[2], right = new int[2];
        if (root.left != null) left = helper(root.left);
        if (root.right != null) right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

}
