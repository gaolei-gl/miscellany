package com.lei.leetcode.P673;

import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] dp = new int[N]; //dp[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    if (dp[i] >= dp[j]) {
                        dp[j] = dp[i] + 1;
                        counts[j] = counts[i];
                    } else if (dp[i] + 1 == dp[j]) {
                        counts[j] += counts[i];
                    }
                }
        }

        int longest = 0, ans = 0;
        for (int length : dp) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (dp[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

}
