package com.lei.leetcode.P221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int ROW = matrix.length, COL = matrix[0].length;
        int[][] dp = new int[ROW][COL];
        int max = 0;
        for (int row = ROW - 1; row >= 0; row--) {
            for (int col = COL - 1; col >= 0; col--) {
                if (matrix[row][col] == 0) continue;
                int min = Math.min(getDP(dp, row + 1, col), getDP(dp, row, col + 1));
                min = Math.min(min, getDP(dp, row + 1, col + 1));
                dp[row][col] = min + 1;
                max = Math.max(dp[row][col], max);
            }
        }
        return max * max;
    }

    private int getDP(int[][] dp, int x, int y) {
        int X = dp.length;
        int Y = dp[0].length;
        if (x >= X || y >= Y) return 0;
        return dp[x][y];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int num = s.maximalSquare(new char[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        });
        System.out.println(num);
    }
}