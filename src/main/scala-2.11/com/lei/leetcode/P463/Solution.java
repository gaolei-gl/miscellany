package com.lei.leetcode.P463;

public class Solution {
    int count = 0;
    int[][] direction = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return this.count;
                }
            }
        }
        return 0;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] != 1) return;
        grid[x][y] = 2;
        if (x == 0) this.count++;
        if (x == grid.length - 1) this.count++;
        if (y == 0) this.count++;
        if (y == grid[0].length - 1) this.count++;
        for (int[] dir : direction) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (inBound(grid, xx, yy)) {
                if (grid[xx][yy] == 0) this.count++;
                else dfs(grid, xx, yy);
            }
        }
    }

    private boolean inBound(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.islandPerimeter(new int[][]{
//                {0, 1, 0, 0},
//                {1, 1, 1, 0},
//                {0, 1, 0, 0},
//                {1, 1, 0, 0},
//        }));
        System.out.println(s.islandPerimeter(new int[][]{
                {0}
//                , {0}
        }));
    }
}
