package com.lei.leetcode.P16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0, distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (Math.abs(nums[i] + nums[lo] + nums[hi] - target) < distance) {
                    sum = nums[i] + nums[lo] + nums[hi];
                    distance = Math.abs(sum - target);
                }
                if (nums[i] + nums[lo] + nums[hi] < target) lo++;
                else hi--;
            }
        }
        return sum;
    }
}
