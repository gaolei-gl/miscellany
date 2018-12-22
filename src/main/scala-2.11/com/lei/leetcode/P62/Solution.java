package com.lei.leetcode.P62;

public class Solution {
    private int total = 0;
    private int M;
    private int N;

    /*
    TLE
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return total;
        this.M = m;
        this.N = n;
        check(1, 1);
        return total;
    }

    private void check(int m, int n) {
        if (m == M && n == N) total++;
        if (m + 1 <= M) check(m + 1, n);
        if (n + 1 <= N) check(m, n + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(23, 12));
    }
}
