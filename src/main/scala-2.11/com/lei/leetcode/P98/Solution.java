package com.lei.leetcode.P98;

import com.lei.leetcode.TreeNode;

public class Solution {
    private Integer last = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (last != null && last >= root.val) return false;
        last = root.val;
        return isValidBST(root.right);
    }

}
