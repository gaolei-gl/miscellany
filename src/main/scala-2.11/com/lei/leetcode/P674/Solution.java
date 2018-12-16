package com.lei.leetcode.P674;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 2) return nums == null ? 0 : nums.length;
        int max = 1;
        int lo = 0, hi = 1;
        while (hi < nums.length) {
            if (nums[hi] > nums[hi - 1]) {
                hi++;
                max = Math.max(max, hi - lo + 1);
            } else {
                lo = hi;
                hi++;
            }
        }
        return max;
    }
}
