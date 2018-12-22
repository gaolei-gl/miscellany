package com.lei.leetcode.P62;

public class Solution2 {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) matrix[i][0] = 1;
        for (int i = 0; i < n; i++) matrix[0][i] = 1;
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.uniquePaths(23, 12));
        System.out.println(s.uniquePaths(4, 3));
    }
}
