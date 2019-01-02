package com.lei.snippet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TruckDeliver {
    static private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int miniStep(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) return -1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        int ans = 0;
        int ROW = matrix.size();
        int COL = matrix.get(0).size();
        boolean[][] visited = new boolean[ROW][COL];
        visited[0][0] = true;
        if (matrix.get(0).get(0) == 2) return 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ans++;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                if (matrix.get(p.x).get(p.y) == 2) return ans;
                if (p.x - 1 >= 0 && !visited[p.x - 1][p.y] && matrix.get(p.x - 1).get(p.y) == 1) {
                    visited[p.x - 1][p.y] = true;
                    q.offer(new Pair(p.x - 1, p.y));
                }
                if (p.x + 1 < ROW && !visited[p.x + 1][p.y] && matrix.get(p.x + 1).get(p.y) == 1) {
                    visited[p.x + 1][p.y] = true;
                    q.offer(new Pair(p.x + 1, p.y));
                }
                if (p.y - 1 >= 0 && !visited[p.x][p.y - 1] && matrix.get(p.x).get(p.y - 1) == 1) {
                    visited[p.x][p.y - 1] = true;
                    q.offer(new Pair(p.x, p.y - 1));
                }
                if (p.y + 1 < COL && !visited[p.x][p.y + 1] && matrix.get(p.x).get(p.y + 1) == 1) {
                    visited[p.x][p.y + 1] = true;
                    q.offer(new Pair(p.x, p.y + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TruckDeliver obj = new TruckDeliver();
    }
}
