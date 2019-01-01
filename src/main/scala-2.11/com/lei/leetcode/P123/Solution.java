package com.lei.leetcode.P123;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[][] dp = new int[3][prices.length];
        for (int i = 1; i < 3; i++) {
            int tmpMax = 0 - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tmpMax + prices[j]);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return Math.max(dp[1][prices.length - 1], dp[2][prices.length - 1]);
    }

    // another resolution from discuss
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for (int p : prices) {
            twoBuyTwoSell = Math.max(twoBuyTwoSell, p + twoBuy);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - p);
            oneBuyOneSell = Math.max(oneBuyOneSell, p + oneBuy);
            oneBuy = Math.max(oneBuy, -p);
        }
        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
}
