package com.lei.leetcode.P309;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int ownLast = 0 - prices[0];
        int notOwnLast = 0;
        int notOwnLast2 = 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int own = Math.max(notOwnLast2 - prices[i], ownLast);
            int notOwn = Math.max(notOwnLast, ownLast + prices[i]);

            notOwnLast2 = notOwnLast;
            ownLast = own;
            notOwnLast = notOwn;
            ans = Math.max(notOwn, own);
        }
        return ans;
    }

}
