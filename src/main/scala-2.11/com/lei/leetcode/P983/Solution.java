package com.lei.leetcode.P983;

import java.util.Arrays;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days[days.length - 1] + 1];
        Arrays.fill(memo, -1);
        return helper(days, costs, memo);
    }

    private int helper(int[] days, int[] costs, int[] memo) {
        if (days.length == 0) return 0;
        if (memo[days[0]] != -1) return memo[days[0]];
        int dp1 = costs[0] + helper(next(days, days[0] + 1), costs, memo);
        int dp7 = costs[1] + helper(next(days, days[0] + 7), costs, memo);
        int dp30 = costs[2] + helper(next(days, days[0] + 30), costs, memo);
        int ans = Math.min(dp1, Math.min(dp7, dp30));
        memo[days[0]] = ans;
        return ans;
    }

    private int[] next(int[] days, int cur) {
        int idx = Arrays.binarySearch(days, cur);
        if (idx < 0) idx = -idx - 1;
        return Arrays.copyOfRange(days, idx, days.length);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(s.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
        System.out.println(s.mincostTickets(new int[]{1, 2, 4, 5, 6, 8, 9, 10, 11, 12, 14, 15, 16, 18, 19, 21, 22, 25, 28, 29, 30, 31, 35, 36, 37, 38, 39, 40, 41, 42, 44, 45, 47, 48, 50, 52, 54, 56, 59, 60, 62, 63, 64, 67, 68, 69, 70, 72, 74, 76, 77, 79, 80, 82, 83, 84, 86, 87, 91, 95, 96, 98}, new int[]{5, 20, 86}));
    }
}
