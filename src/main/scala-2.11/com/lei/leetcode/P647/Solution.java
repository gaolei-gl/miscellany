package com.lei.leetcode.P647;

public class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int N = chars.length;
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) dp[j][i] = true;
                else if (chars[i] == chars[j]) {
                    if (i - j == 1) dp[j][i] = true;
                    else if (i - 1 >= 0 && j + 1 < N) {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j]) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("abc"));
        System.out.println(s.countSubstrings("aaa"));
        System.out.println(s.countSubstrings("aba"));
    }
}
