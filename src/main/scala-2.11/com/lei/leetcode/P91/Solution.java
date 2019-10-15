package com.lei.leetcode.P91;

import java.util.Arrays;


class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        int i = numDecodings(s, 0, dp);
        return i;
//        return dp[s.length() - 1];

    }

    private int numDecodings(String s, int idx, int[] dp) {
        if (idx >= s.length()) return 1;
        if (dp[idx] >= 0) return dp[idx];

        int howManyWays = 0;
        if (idx + 1 <= s.length()) {
            String firstWay = s.substring(idx, idx + 1);
            if (isValid(firstWay)) howManyWays += numDecodings(s, idx + 1, dp);
        }
        if (idx + 2 <= s.length()) {
            String secondWay = s.substring(idx, idx + 2);
            if (isValid(secondWay)) howManyWays += numDecodings(s, idx + 2, dp);
        }

        dp[idx] = howManyWays;
        return howManyWays;
    }

    private boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }

        if (s.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(s);

        return value >= 1 && value <= 26;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("12"));
        System.out.println(s.numDecodings("226"));
    }

}