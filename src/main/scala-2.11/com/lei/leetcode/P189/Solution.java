package com.lei.leetcode.P189;

/**
 * Created by lei on 17-7-13.
 */
public class Solution {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }

    public static void reverse(int[] nums, int start, int end) {
        int len = end - start;
        int half = len / 2;
        for (int i = 0; i < half; i++) {
            int swap = nums[i + start];
            nums[i + start] = nums[end - 1 - i];
            nums[end - 1 - i] = swap;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(a, 3);
//        reverse(a, 0, 3);
        for (int i :
                a) {
            System.out.println(i);
        }
    }
}
