package com.lei.leetcode.P958;

import com.lei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private class Node {
        public int idx;
        public TreeNode node;

        public Node(TreeNode root, int idx) {
            this.node = root;
            this.idx = idx;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null) return true;
        q.offer(new Node(root, 1));
        while (!q.isEmpty()) {
            Node n = q.poll();
            ans.add(n.idx);
            if (n.node.left != null) q.offer(new Node(n.node.left, n.idx * 2));
            if (n.node.right != null) q.offer(new Node(n.node.right, n.idx * 2 + 1));
        }
        for (int i = 0; i < ans.size() - 1; i++) {
            if (ans.get(i) + 1 != ans.get(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.right = six;
        System.out.println(s.isCompleteTree(root));
    }
}
