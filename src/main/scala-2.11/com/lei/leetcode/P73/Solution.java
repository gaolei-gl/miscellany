package com.lei.leetcode.P73;


public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;
        int ROW = matrix.length;
        if (ROW == 0)
            return;
        boolean column0 = false;
        boolean row0 = false;
        int COL = matrix[0].length;
        for (int i = 0; i < ROW; i++) {
            if (matrix[i][0] == 0) {
                column0 = true;
                break;
            }
        }
        for (int i = 0; i < COL; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < ROW; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < COL; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 1; col < COL; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < ROW; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (column0) {
            for (int i = 0; i < ROW; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0) {
            for (int i = 0; i < COL; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] data = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        s.setZeroes(data);
        System.out.println();
    }

}