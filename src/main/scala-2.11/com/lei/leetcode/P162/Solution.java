package com.lei.leetcode.P162;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && ((mid == n - 1 || nums[mid] > nums[mid + 1])))
                return mid;
            if (mid < end && nums[mid] < nums[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1, 2}));
        System.out.println(s.findPeakElement(new int[]{2, 1}));
        System.out.println(s.findPeakElement(new int[]{3, 2, 1}));
        System.out.println(s.findPeakElement(new int[]{1, 2, 3}));
    }
}