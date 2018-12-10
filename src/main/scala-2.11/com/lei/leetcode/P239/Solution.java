package com.lei.leetcode.P239;

import com.lei.leetcode.Utils;

import java.util.Arrays;

public class Solution {
    /* Memory Limit Exceeded */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;
        else if (k == 0) {
            int[] ans = new int[nums.length + 1];
            ans[0] = nums[0];
            int j = 1;
            for (int i : nums) ans[j++] = i;
            return ans;
        }
        int len = nums.length;
        int[][] dp = build(nums);
        int max[] = new int[len - k + 1];
        for (int i = 0; i + k <= len; i++) {
            max[i] = dp[i][i + k - 1];
        }
        return max;
    }

    private int[][] build(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Math.max(nums[j], dp[j + 1][i]);
            }
        }
//        Utils.displayList(dp);
        return dp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int k = 2;
        long ts = System.currentTimeMillis();
        int[] data = new int[]{1, 2, 3, 4, 5};
        int[] ans = s.maxSlidingWindow(data, k);
        System.out.println(System.currentTimeMillis() - ts);

        Utils.displayList(ans);
    }
}
