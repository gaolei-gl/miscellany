package com.lei.leetcode.P643;

import java.util.Arrays;

/**
 * Created by Lei on 2017/7/19.
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        int i = 0;
        for (i = 0; i < k; i++) sum += nums[i];
        long maxSum = sum;
        while (i < nums.length) {
            sum += -nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
            i++;
        }

        return maxSum * 1.0 / k;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 12, -5, -6, 50, 3};
//        int[] a = new int[]{-1};
        System.out.println(findMaxAverage(a, 3));
    }
}
