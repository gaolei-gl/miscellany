package com.lei.leetcode.P538;

import com.lei.leetcode.TreeNode;

public class Solution2 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
