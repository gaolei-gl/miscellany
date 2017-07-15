package com.lei.leetcode.P561;

import java.util.Arrays;

/**
 * Created by Lei on 2017/7/15.
 */
public class Solution {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(a));
    }
}
