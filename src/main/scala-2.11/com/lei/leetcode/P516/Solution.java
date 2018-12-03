package com.lei.leetcode.P516;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // this will have a Time Limit Exceeded
    public int longestPalindromeSubseq(String s) {
        int[][] mem = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) mem[i][i] = 1;
        return dp(s, 0, s.length() - 1, mem);
    }

    // top-down
    private int dp(String s, int start, int end, int[][] mem) {
        /*
         * if (start == end) return 1;
         * if (start < end) return 0;
         */
        int len = end - start;
        if (len <= 0) return len + 1;       // return statement     exit strategy

        if (mem[start][end] > 0)
            return mem[start][end];
        if (s.charAt(start) == s.charAt(end))
            mem[start][end] = 2 + dp(s, start + 1, end - 1, mem);
        else
            mem[start][end] = Math.max(dp(s, start + 1, end, mem), dp(s, start, end - 1, mem));
        return mem[start][end];
    }

    // bottom-up
    public int longestPalindromeSubseq1(String s) {
        int[][] mem = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            mem[i][i] = 1;
            char end = s.charAt(i);
            for (int j = i - 1; j >= 0; j--) {
                if (j < 0) continue;
                if (end == s.charAt(j))
                    mem[j][i] = 2 + mem[j + 1][i - 1];
                else
                    mem[j][i] = Math.max(mem[j + 1][i], mem[j][i - 1]);
            }
        }
        return mem[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindromeSubseq1("bbbab"));
        System.out.println(s.longestPalindromeSubseq1("cabc"));
    }
}
