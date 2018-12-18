package com.lei.leetcode.P200;

import java.util.Arrays;

class Solution {

    public static class CC {
        private int X;
        private int Y;
        private int count;
        private boolean[][] marked;
        private char[][] grid;


        public CC(char[][] grid) {
            this.X = grid.length;
            this.Y = grid[0].length;
            marked = new boolean[X][Y];
            this.grid = grid;

            for (int x = 0; x < X; x++) {
                for (int y = 0; y < Y; y++) {
                    if (grid[x][y] == '1' && !marked[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
        }

        public void dfs(int x, int y) {
            marked[x][y] = true;
            if (x - 1 >= 0 && this.grid[x - 1][y] == '1' && !marked[x - 1][y]) dfs(x - 1, y);
            if (x + 1 < X && this.grid[x + 1][y] == '1' && !marked[x + 1][y]) dfs(x + 1, y);
            if (y - 1 >= 0 && this.grid[x][y - 1] == '1' && !marked[x][y - 1]) dfs(x, y - 1);
            if (y + 1 < Y && this.grid[x][y + 1] == '1' && !marked[x][y + 1]) dfs(x, y + 1);
        }

        public int count() {
            return count;
        }

    }


    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;
        if (grid.length == 0) return 0;
        CC c = new CC(grid);
        return c.count();
    }

    public static void main(String[] args) {

        char[][] test1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] test2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };


        System.out.println(numIslands(test1));
        System.out.println(numIslands(test2));


    }
}

