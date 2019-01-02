package com.lei.snippet;

import com.lei.leetcode.TreeNode;

public class BuildBSTCountDistance {
    public int buildAndCount(int[] a, int n1, int n2) {
        // check parameter
        if (a == null || a.length < 2) return -1;
        boolean notFoundN1 = true, notFoundN2 = true;
        for (int i : a) {
            if (i == n1) notFoundN1 = false;
            if (i == n2) notFoundN2 = false;
        }
        if (notFoundN1 || notFoundN2) return -1;

        // build the BST
        TreeNode root = buildBST(a);

        // find the LCA
        TreeNode lca = findLCA(root, n1, n2);
        return distance(lca, n1, 0) + distance(lca, n2, 0);

    }


    private int distance(TreeNode root, int n, int level) {
        if (root.val == n) return level;
        if (root.val > n) return distance(root.left, n, level + 1);
        return distance(root.right, n, level + 1);
    }

    private TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null) return null;
        if (root.val > n1 && root.val > n2) return findLCA(root.left, n1, n2);
        else if (root.val < n1 && root.val < n2) return findLCA(root.right, n1, n2);
        return root;
    }

    private TreeNode buildBST(int[] a) {
        TreeNode root = new TreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            add(root, a[i]);
        }
        return root;
    }

    private void add(TreeNode root, int n) {
        if (root.val > n) {
            if (root.left == null) root.left = new TreeNode(n);
            else add(root.left, n);
        } else {
            if (root.right == null) root.right = new TreeNode(n);
            else add(root.right, n);
        }
    }

    public static void main(String[] args) {
        BuildBSTCountDistance obj = new BuildBSTCountDistance();
        int a = obj.buildAndCount(new int[]{2, 0, 3, 5, 6, 4, 7, 8, 1}, 1, 4);
        int b = obj.buildAndCount(new int[]{5,6,3,1,2,4}, 1, 4);
        System.out.println(b);
    }
}
