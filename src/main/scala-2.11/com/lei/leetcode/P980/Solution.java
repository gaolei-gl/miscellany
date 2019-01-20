package com.lei.leetcode.P980;

public class Solution {
    int X = 0, Y = 0;
    int res = 0;
    int[][] directions = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int uniquePathsIII(int[][] grid) {
        this.X = grid.length;
        this.Y = grid[0].length;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return res;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 2 && valid(grid)) {
            this.res++;
            return;
        }
        grid[x][y] = -1;
        for (int[] dir : directions) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (inBorder(xx, yy) && grid[xx][yy] != -1) {
                int t = grid[xx][yy];
                dfs(grid, xx, yy);
                grid[xx][yy] = t;
            }
        }
    }

    private boolean valid(int[][] grid) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (grid[i][j] == 0) return false;
            }
        }
        return true;
    }

    private boolean inBorder(int x, int y) {
        return x >= 0 && y >= 0 && x < X && y < Y;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.uniquePathsIII(new int[][]{
//                {1, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 2}
//        }));

//        System.out.println(s.uniquePathsIII(new int[][]{
//                {1, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 2, -1}
//        }));

        System.out.println(s.uniquePathsIII(new int[][]{
                {0, 1},
                {2, 0}
        }));
    }
}
