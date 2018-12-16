package com.lei.leetcode.P5;

public class SolutionDP {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        boolean[][] dp = new boolean[s.length()][];
        int max = 0;
        int start = 0, end = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new boolean[s.length()];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        SolutionDP dp = new SolutionDP();
        System.out.println(dp.longestPalindrome("abcda"));
    }
}
