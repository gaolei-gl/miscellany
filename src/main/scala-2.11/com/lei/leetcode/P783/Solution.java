package com.lei.leetcode.P783;

import com.lei.leetcode.TreeNode;

public class Solution {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) min = Math.min(root.val - pre.val, min);
        pre = root;
        if (root.right != null) minDiffInBST(root.right);
        return min;
    }
}
