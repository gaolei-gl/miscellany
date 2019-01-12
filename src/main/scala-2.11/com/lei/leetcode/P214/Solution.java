package com.lei.leetcode.P214;

public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int N = s.length();
        boolean dp[][] = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i] = true;
                    continue;
                }
                if (s.charAt(j) == s.charAt(i)) {
                    if (j + 1 == i) dp[j][i] = true;
                    else if (j + 1 < N && i - 1 >= 0) {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
            }
        }
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (dp[0][i]) idx = i;
        }
        if (idx == N) return s;
        return new StringBuilder(s.substring(idx + 1)).reverse().toString() + s;

    }
    public String shortestPalindrome2(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.shortestPalindrome("aacecaaa"));
//        System.out.println(s.shortestPalindrome("abcd"));
        System.out.println(s.shortestPalindrome2("ccba"));
    }
}
