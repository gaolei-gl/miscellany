package com.lei.leetcode.P53;

public class Solution {
    public static int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sum < 0) {
                max = Math.max(max, sum);
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
