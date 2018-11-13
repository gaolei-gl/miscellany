package com.lei.leetcode.P236;

import com.lei.leetcode.TreeNode;

public class Solution {
    private boolean cover(TreeNode t, TreeNode p) {
        if (t == null) return false;
        if (t == p) return true;
        return cover(t.left, p) || cover(t.right, p);
    }

    public TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) return root;
        boolean pInLeft = cover(root.left, p);
        boolean qInLeft = cover(root.left, q);
        if (pInLeft != qInLeft) return root;
        if (pInLeft) {
            return ancestorHelper(root.left, p, q);
        } else {
            return ancestorHelper(root.right, p, q);
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) return null;
        return ancestorHelper(root, p, q);
    }

}
