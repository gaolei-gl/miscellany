package com.lei.leetcode.P695;

public class Solution {
    private int max = 0;
    private int M, N = 0;
    private final int[][] directions = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return this.max;
        this.M = grid.length;
        this.N = grid[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j, 0);
                    max = Math.max(max, cur);
                }

            }
        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y, int cur) {
        cur++;
        grid[x][y] = 0;
        for (int[] dir : directions) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (inBound(xx, yy) && grid[xx][yy] == 1) {
                cur = dfs(grid, xx, yy, cur);
            }
        }
        return cur;
    }

    private boolean inBound(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
