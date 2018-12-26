package com.lei.leetcode.P173;

import com.lei.leetcode.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int t = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return t;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */