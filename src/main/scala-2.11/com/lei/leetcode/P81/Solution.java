package com.lei.leetcode.P81;

public class Solution {
    private int[] nums;
    private int target;

    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if (nums == null || nums.length == 0) return false;
        return find(0, nums.length - 1) != -1;
    }

    private int find(int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            while (nums[end] == nums[mid] && end != mid) end--;
            while (nums[start] == nums[mid] && start != mid) start++;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
