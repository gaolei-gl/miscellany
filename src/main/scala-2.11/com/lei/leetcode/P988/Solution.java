package com.lei.leetcode.P988;

import com.lei.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, String> map = new HashMap<>();

    public String smallestFromLeaf(TreeNode root) {
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c - 'a', String.valueOf(c));
        }
        return helper(root);
    }

    private String helper(TreeNode root) {
        if (root == null) return null;
        String left = helper(root.left);
        String right = helper(root.right);
        if (left == null && right == null) return map.get(root.val);
        else if(left == null) return right + map.get(root.val);
        else if(right == null) return left + map.get(root.val);
        return left.compareTo(right) < 0 ? left + map.get(root.val) : right + map.get(root.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
