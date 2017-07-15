package com.lei.leetcode.P581;

import java.util.Arrays;

/**
 * Created by Lei on 2017/7/14.
 */
public class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] sorted = Arrays.copyOf(nums, length);
        Arrays.sort(sorted);
        int begin = length - 1, end = 0;
        for (int i = 0; i < length; i++) {
            if (sorted[i] != nums[i]) {
                begin = Math.min(begin, i);
                end = Math.max(end, i);
            }
        }
        return end - begin <= 0 ? 0 : end - begin + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1};
//        int[] a = new int[]{1, 2, 3, 4};
        System.out.println(findUnsortedSubarray(a));
    }
}
