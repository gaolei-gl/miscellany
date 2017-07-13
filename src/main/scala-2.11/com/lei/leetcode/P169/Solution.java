package com.lei.leetcode.P169;

/**
 * Created by lei on 17-7-13.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) count++;
            else if (count == 0) {
                majority = nums[i];
                count++;
            } else count--;
        }
        return majority;
    }
}
