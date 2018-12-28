package com.lei.leetcode.P654;

import com.lei.leetcode.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int idx = findBiggestIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, start, idx - 1);
        root.right = helper(nums, idx + 1, end);
        return root;
    }

    private int findBiggestIndex(int[] nums, int start, int end) {
        int max = nums[start];
        int idx = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
