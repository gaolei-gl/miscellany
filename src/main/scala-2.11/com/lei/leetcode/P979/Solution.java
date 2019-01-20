package com.lei.leetcode.P979;

import com.lei.leetcode.TreeNode;

public class Solution {
    int step = 0;

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int res = root.val - 1 + left + right;
        step += Math.abs(left) + Math.abs(right);
        return res;
    }

    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return step;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(0);
        t.left.right = new TreeNode(0);
        t.left.right.right = new TreeNode(0);

//        TreeNode t = new TreeNode(3);
//        t.left = new TreeNode(0);
//        t.right = new TreeNode(0);

//        TreeNode t = new TreeNode(0);
//        t.left = new TreeNode(3);
//        t.right = new TreeNode(0);

//        TreeNode t = new TreeNode(1);
//        t.left = new TreeNode(0);
//        t.right = new TreeNode(2);

        System.out.println(s.distributeCoins(t));
    }
}
