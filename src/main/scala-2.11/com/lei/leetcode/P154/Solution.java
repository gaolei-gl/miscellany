package com.lei.leetcode.P154;

/**
 * 1. remove the equal value on both side.
 * 2. then it becomes the linear monotonically increasing problem. (may have the equal value in the middle, but not a problem)
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int start = 0, end = nums.length - 1;

        //only need to add the following while loop on top of the solution
        //for Part I
        //if two line segments have overlap, remove the overlap.
        //so, the problem can be solved as Part I
        while (nums[end] == nums[start] && end > start) {
            end--;
        }

        while (start < end) {
            //if the linear monotonically increasing in [start, end]
            if (nums[start] < nums[end]) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}

