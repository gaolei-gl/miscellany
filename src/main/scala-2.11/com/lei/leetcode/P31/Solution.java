package com.lei.leetcode.P31;

import com.lei.leetcode.Utils;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, nums.length);
                int idx = Arrays.binarySearch(nums, i, nums.length, nums[i - 1]);
                if (idx < 0) idx = -idx - 1;
                while (nums[idx] == nums[i - 1]) idx++;
                swap(nums, i - 1, idx);
                return;
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - i - 1);
        }
    }

    private void swap(int[] A, int a, int b) {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextPermutation(new int[]{1, 2, 3});
        s.nextPermutation(new int[]{3, 2, 1});
        s.nextPermutation(new int[]{1, 3, 5, 2, 6});
    }
}
