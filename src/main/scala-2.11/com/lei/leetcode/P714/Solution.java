package com.lei.leetcode.P714;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) return 0;
        int ownLast = 0 - fee - prices[0];
        int notOwnLast = 0;
        for (int i = 1; i < prices.length; i++) {
            int own = Math.max(ownLast, notOwnLast - prices[i] - fee);
            int notOwn = Math.max(notOwnLast, ownLast + prices[i]);
            ownLast = own;
            notOwnLast = notOwn;
        }
        return Math.max(ownLast, notOwnLast);
    }
}
