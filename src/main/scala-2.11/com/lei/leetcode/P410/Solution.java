package com.lei.leetcode.P410;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/split-array-largest-sum/description/
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{
                7, 2, 5, 10, 8
        };
        System.out.println(splitArray(nums, 2));

    }

    public static int splitArray(int[] nums, int m) {
        long sum = 0L;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        long lo = max;
        long hi = sum;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (valid(nums, mid, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo;
    }

    private static boolean valid(int[] nums, long target, int m) {
        int count = 1;
        long total = 0L;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }
}
