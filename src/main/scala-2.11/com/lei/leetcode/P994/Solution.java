package com.lei.leetcode.P994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[][] directions = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> next = new LinkedList<>();
        int step = -1;
        int freshCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    next.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }
        if (next.isEmpty() && freshCnt != 0) return -1;
        if (next.isEmpty()) return 0;

        while (!next.isEmpty()) {
            step++;
            int size = next.size();
            for (int i = 0; i < size; i++) {
                int[] p = next.poll();
                for (int[] dir : directions) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {  // within border
                        if (grid[x][y] == 1) {
                            next.offer(new int[]{x, y});
                            freshCnt--;
                            grid[x][y] = 2;
                        }
                    }
                }
            }
        }
        if (freshCnt == 0) return step;
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
    }
}
