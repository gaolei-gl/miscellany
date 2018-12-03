package com.lei.leetcode.P538;

import com.lei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 */
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        List<Integer> sequence = new ArrayList<>();
        inOrder(root, sequence);
        for (int i = sequence.size() - 2; i >= 0; i--) {
            sequence.set(i, sequence.get(i) + sequence.get(i + 1));
        }
        convert(root, sequence);
        return root;
    }

    private void convert(TreeNode root, List<Integer> sequence) {
        if (root == null) return;
        convert(root.left, sequence);
        root.val = sequence.remove(0);
        convert(root.right, sequence);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        Solution s = new Solution();
        s.convertBST(null);
        System.out.println(s);
    }
}
