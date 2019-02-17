package com.lei.leetcode.P993;

import com.lei.leetcode.TreeNode;

public class Solution {
    int xLevel = -1;
    int yLevel = -1;
    TreeNode xFather;
    TreeNode yFather;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, 0, x, y);
        return xLevel == yLevel && xFather != yFather;
    }

    private void helper(TreeNode root, int level, int x, int y) {
        if (root == null) return;
        helper(root.left, level + 1, x, y);
        helper(root.right, level + 1, x, y);
        if (root.val == x) xLevel = level;
        if (root.val == y) yLevel = level;
        if (root.left != null) {
            if (root.left.val == x) xFather = root;
            if (root.left.val == y) yFather = root;
        }
        if (root.right != null) {
            if (root.right.val == x) xFather = root;
            if (root.right.val == y) yFather = root;
        }
    }

}
