package com.lei.leetcode.P198;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return helper(nums, 0, cache);
    }

    private int helper(int[] nums, int idx, int[] cache) {
        if (idx >= nums.length) return 0;
        if (cache[idx] == -1)
            cache[idx] = Math.max(nums[idx] + helper(nums, idx + 2, cache), helper(nums, idx + 1, cache));
        return cache[idx];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{1, 2, 3, 1}));
        System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(s.rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
    }
}
