package com.lei.leetcode.P152;

public class Solution2 {
    public int maxProduct(int[] nums) {
        int r = nums[0];
        for (int i = 1, iMax = r, iMin = r; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = iMax;
                iMax = iMin;
                iMin = t;
            }
            iMin = Math.min(nums[i], iMin * nums[i]);
            iMax = Math.max(nums[i], iMax * nums[i]);
            r = Math.max(r, iMax);
        }
        return r;
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        System.out.println(s2.maxProduct(new int[]{-5, 6}));
    }
}
