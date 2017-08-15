package com.lei.leetcode.P35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] == target)
                break;
            if (nums[i] > target) {
                break;
            }
            i++;
        }
        return i;
    }
}
