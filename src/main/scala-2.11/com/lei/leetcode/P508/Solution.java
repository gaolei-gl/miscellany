package com.lei.leetcode.P508;

import com.lei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        sumTree(root);
        Map<Integer, Integer> cnt = new HashMap<>();
        traverse(root, cnt);
        Map<Integer, List<Integer>> reverCnt = new HashMap<>();
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int count = entry.getValue();
            int num = entry.getKey();
            List<Integer> m = reverCnt.getOrDefault(count, new ArrayList<>());
            m.add(num);
            max = Math.max(max, count);
            reverCnt.put(count, m);
        }
        List<Integer> l = reverCnt.get(max);
        int[] ll = new int[l.size()];
        for (int i = 0; i < l.size(); i++) ll[i] = l.get(i);
        return ll;
    }

    private void traverse(TreeNode root, Map<Integer, Integer> cnt) {
        if (root == null) return;
        cnt.putIfAbsent(root.val, 0);
        cnt.put(root.val, cnt.get(root.val) + 1);
        traverse(root.left, cnt);
        traverse(root.right, cnt);
    }

    private int sumTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        int sum = left + right + root.val;
        root.val = sum;
        return sum;
    }

}
