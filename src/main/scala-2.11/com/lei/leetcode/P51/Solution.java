package com.lei.leetcode.P51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static class Grid {
        int SIZE;
        List<String> grid;
        List<List<String>> possibleWay;

        public Grid(int n) {
            this.SIZE = n;
            this.grid = new ArrayList<>();
            char[] v = new char[n];
            Arrays.fill(v, '.');
            for (int i = 0; i < n; i++)
                this.grid.add(String.valueOf(v));
            possibleWay = new ArrayList<>();
        }

        boolean check(int r, int c) {
            for (int i = 0; i <= r; i++) {
                String row = grid.get(i);
                int col = row.indexOf("Q");
                if (col == c) return false;
                int rowDistance = r - i;
                if (Math.abs(col - c) == rowDistance) return false;
            }
            return true;
        }

        public void place(int r) {
            if (r == SIZE) {
                possibleWay.add(new ArrayList(this.grid));
            }
            for (int c = 0; c < SIZE; c++) {
                if (!check(r, c)) continue;
                String s = this.grid.get(r);
                this.grid.set(r, s.substring(0, c) + "Q" + s.substring(c + 1));
                place(r + 1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        Grid grid = new Grid(n);
        for (int i = 0; i < n; i++) {
            grid.place(i);
        }
        return grid.possibleWay;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ways = s.solveNQueens(4);
        for (List<String> ss : ways) {
            for (String vs : ss) {
                System.out.println(vs);
            }
        }
    }

}
