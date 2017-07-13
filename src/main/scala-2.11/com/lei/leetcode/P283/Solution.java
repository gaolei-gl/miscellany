package com.lei.leetcode.P283;

/**
 * Created by lei on 17-7-13.
 */
public class Solution {
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int begin = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[begin++] = nums[i];
            }
        }
        while (begin < length) nums[begin++] = 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        moveZeroes(a);
        for (int i :
                a) {
            System.out.println(i);
        }
    }
}
