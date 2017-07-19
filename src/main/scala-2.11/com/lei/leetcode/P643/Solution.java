package com.lei.leetcode.P643;

/**
 * Created by Lei on 2017/7/19.
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int i = 0;
        while (i < nums.length && nums[i] <= 0) i++;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(a, 4));
    }
}
