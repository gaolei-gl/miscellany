package com.lei.leetcode.P188;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) return greedy(prices);
        int[][] dp = new int[k + 1][prices.length];

        for (int t = 1; t <= k; t++) {
            int tmpMax = 0 - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[t][j] = Math.max(dp[t][j - 1], tmpMax + prices[j]);
                tmpMax = Math.max(tmpMax, dp[t - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    private int greedy(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
        }
        return ans;
    }
}
