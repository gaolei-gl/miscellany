package com.lei.leetcode.P991;

public class Solution {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        if (X >= Y) return X - Y;
        while (Y > X) {
            if ((Y & 1) == 1) {
                Y += 1;
                res++;
            }
            Y >>= 1;
            res++;
        }
        return res + X - Y;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.brokenCalc(1, 1000000000));
        System.out.println(s.brokenCalc(1024, 1));
    }
}
