package com.lei.leetcode.P322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return countChange(coins, amount, new int[amount]);
    }

    private int countChange(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = countChange(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount - 1];
    }

    /**
     * bottom up
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(s.coinChange(new int[]{2}, 3));
        System.out.println(s.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(s.coinChange(new int[]{288, 160, 10, 249, 40, 77, 314, 429}, 9208));
    }
}
