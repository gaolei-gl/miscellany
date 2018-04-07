package com.lei.leetcode.P300;

import java.util.Arrays;

public class BinarySearchSolution {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(dp, 0, len, num);
            if (idx < 0) {
                idx = -(idx + 1);
                if (idx >= len) {
                    len += 1;
                }
                dp[idx] = num;
            }

        }
        return len;
    }


    public static void main(String[] args) {
        int[] a = new int[]{10, 9, 2, 5, 3, 4};
        System.out.println(lengthOfLIS(a));
    }
}
