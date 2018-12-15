package com.lei.leetcode.P542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    Queue<Pair> q;

    private class Pair {
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int X = matrix.length;
        int Y = matrix[0].length;
        q = new LinkedList<>();
        int[][] dest = new int[X][];
        for (int i = 0; i < X; i++) {
            dest[i] = new int[Y];
            for (int j = 0; j < Y; j++) {
                if (matrix[i][j] == 0) dest[i][j] = 0;
                else dest[i][j] = Integer.MAX_VALUE;
            }

        }
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (matrix[i][j] == 0) q.add(new Pair(i, j, 0));
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x - 1 >= 0 && dest[p.x - 1][p.y] == Integer.MAX_VALUE) {
                dest[p.x - 1][p.y] = p.dist + 1;
                q.add(new Pair(p.x - 1, p.y, p.dist + 1));
            }
            if (p.x + 1 < X && dest[p.x + 1][p.y] == Integer.MAX_VALUE) {
                dest[p.x + 1][p.y] = p.dist + 1;
                q.add(new Pair(p.x + 1, p.y, p.dist + 1));
            }
            if (p.y - 1 >= 0 && dest[p.x][p.y - 1] == Integer.MAX_VALUE) {
                dest[p.x][p.y - 1] = p.dist + 1;
                q.add(new Pair(p.x, p.y - 1, p.dist + 1));
            }
            if (p.y + 1 < Y && dest[p.x][p.y + 1] == Integer.MAX_VALUE) {
                dest[p.x][p.y + 1] = p.dist + 1;
                q.add(new Pair(p.x, p.y + 1, p.dist + 1));
            }
        }

        return dest;
    }
}
