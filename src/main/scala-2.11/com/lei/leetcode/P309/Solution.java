package com.lei.leetcode.P309;

// my fucked and stupid and not working solution
public class Solution {
    int[][] dp;

    public int maxProfit(int[] prices) {
        int N = prices.length;
        dp = new int[N][N];
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int max = prices[j] - prices[i];
                for (int k = j - 2; k > i; k--) {
                    int t = getDP(prices, i, k) + getDP(prices, k + 2, j);
                    max = Math.max(max, t);
                }
                dp[i][j] = max;
                MAX = Math.max(max, MAX);
            }
        }
        return MAX;
    }

    private int getDP(int[] prices, int x, int y) {
        if (x == y) return 0;
        if (x >= dp.length || y >= dp.length) return 0;
        if (y - x == 1) return prices[y] - prices[x];
        return dp[x][y];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{2, 1, 2, 1, 0, 0, 1}));
    }
}
