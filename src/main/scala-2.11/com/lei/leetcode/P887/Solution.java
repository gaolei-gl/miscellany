package com.lei.leetcode.P887;

public class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int egg = 2; egg <= K; egg++) {
            for (int floor = 1; floor <= N; floor++) {
                dp[egg][floor] = Integer.MAX_VALUE;
                for (int i = 1; i <= floor; i++) {
                    int attempt = 1 + Math.max(dp[egg - 1][i - 1], dp[egg][floor - i]);
                    if (dp[egg][floor] > attempt) dp[egg][floor] = attempt;
                }
            }
        }
        return dp[K][N];
    }

    public int superEggDrop2(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }

    public int calculateRecursive(int eggs, int floors) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0) {
            return 0;
        }
        int min = 1000;     // declared restriction
        for (int i = 1; i <= floors; i++) {
            int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.superEggDrop(2, 6));
        System.out.println(s.calculateRecursive(2, 6));
        System.out.println();
        System.out.println(s.superEggDrop(3, 14));
        System.out.println(s.calculateRecursive(3, 14));
        System.out.println();
        System.out.println(s.superEggDrop(1, 2));
        System.out.println(s.calculateRecursive(1, 2));
    }
}
