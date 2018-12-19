package com.lei.leetcode.P74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int ROW = matrix.length;
        int COL = matrix[0].length;
        int row = ROW - 1;
        int col = 0;
        while (row >= 0 && col < COL) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) col++;
            else row--;
        }
        return false;
    }
}
