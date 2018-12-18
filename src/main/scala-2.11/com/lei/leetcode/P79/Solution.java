package com.lei.leetcode.P79;

public class Solution {
    char[][] B;
    int X;
    int Y;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        B = board;
        X = board.length;
        Y = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (B[i][j] == chars[0]) {
                    used = new boolean[X][Y];
                    boolean b = find(chars, i, j, 0);
                    if (b) return b;
                }
            }
        }
        return false;
    }

    private boolean find(char[] chars, int row, int col, int idx) {
        if (used[row][col]) return false;
        if (idx == chars.length - 1) return true;
        used[row][col] = true;
        if (row - 1 >= 0 && B[row - 1][col] == chars[idx + 1]) {
            boolean b = find(chars, row - 1, col, idx + 1);
            if (b) return b;
        }
        if (row + 1 < X && B[row + 1][col] == chars[idx + 1]) {
            boolean b = find(chars, row + 1, col, idx + 1);
            if (b) return b;
        }
        if (col - 1 >= 0 && B[row][col - 1] == chars[idx + 1]) {
            boolean b = find(chars, row, col - 1, idx + 1);
            if (b) return b;
        }
        if (col + 1 < Y && B[row][col + 1] == chars[idx + 1]) {
            boolean b = find(chars, row, col + 1, idx + 1);
            if (b) return b;
        }
        used[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        s.exist(board, "ABCESEEEFS");

    }
}
