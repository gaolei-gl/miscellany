package com.lei.leetcode.P633;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }

    public static boolean isSqureNum(int n) {
        double sqrt = Math.sqrt(n);
        int x = (int) sqrt;
        return (Math.pow(sqrt, 2) == Math.pow(x, 2));
    }

    public static boolean judgeSquareSum(int c) {
        int i = 0;
        int square = i * i;
        while ((c - square) >= (c / 2)) {
            int left = c - square;
            if (isSqureNum(left)) {
                return true;
            }
            i++;
            square = i * i;
        }
        return false;
    }
}
