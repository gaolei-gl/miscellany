package com.lei.leetcode.P268;

import java.util.Arrays;

/**
 * Created by lei on 17-7-13.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        boolean[] a = new boolean[nums.length + 1];
        Arrays.fill(a, false);
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = true;
        }

        int i = 0;
        while (i < a.length && a[i])
            i++;
        return i;
    }
}
