package com.lei.leetcode.P518;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.change(5, new int[]{1, 2, 5}));
        System.out.println(s.change(3, new int[]{2}));
    }
}
