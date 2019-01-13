package com.lei.leetcode.P974;

public class Solution {
    // TLE
    public int dp(int[] A, int K) {
        int N = A.length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            int[] dp = new int[N];
            for (int j = i; j < N; j++) {
                if (i == j || j == 0) dp[j] = A[j];
                else dp[j] = dp[j - 1] + A[j];
                if (dp[j] % K == 0) res++;
            }
        }
        return res;
    }

    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        int[] count = new int[K];
        for (int x: P)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v: count)
            ans += v * (v - 1) / 2;
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
