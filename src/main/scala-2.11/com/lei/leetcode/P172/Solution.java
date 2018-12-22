package com.lei.leetcode.P172;

public class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        for (long i = 5; n / i > 0; i = i * 5) {
            cnt += n / i;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trailingZeroes(1808548329));
    }
}
