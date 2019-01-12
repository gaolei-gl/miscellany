package com.lei.leetcode.P11;

public class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[j], height[i]));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }
}
