package com.lei.leetcode.P51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static class Grid {
        int SIZE;
        List<String> grid;
        List<List<String>> possibleWay;

        Grid(int n) {
            this.SIZE = n;
            init();
            possibleWay = new ArrayList<>();
        }

        void init() {
            char[] v = new char[SIZE];
            Arrays.fill(v, '.');
            this.grid = new ArrayList<>();
            for (int i = 0; i < SIZE; i++)
                this.grid.add(String.valueOf(v));
        }

        boolean check(int r, int c) {
            if (grid.get(r).contains("Q")) return false;
            for (int i = 0; i < r; i++) {
                String row = grid.get(i);
                int col = row.indexOf("Q");
                if (col == c) return false;
                int rowDistance = r - i;
                if (Math.abs(col - c) == rowDistance) return false;
            }
            return true;
        }

        void set(int r, int c) {
            String s = this.grid.get(r);
            this.grid.set(r, s.substring(0, c) + "Q" + s.substring(c + 1));
        }

        void place(int r) {
            if (r == SIZE) {
                possibleWay.add(new ArrayList(this.grid));
            } else {
                for (int c = 0; c < SIZE; c++) {
                    if (!check(r, c)) continue;
                    String s = this.grid.get(r);
                    this.grid.set(r, s.substring(0, c) + "Q" + s.substring(c + 1));
                    place(r + 1);
                    this.grid.set(r, s);
                }
            }
        }
    }

    List<List<String>> solveNQueens(int n) {
        Grid grid = new Grid(n);
        for (int i = 1; i < n; i++) {
            grid.set(0, i - 1);
            grid.place(1);
            grid.init();
        }
        grid.set(0, n - 1);
        grid.place(1);
        return grid.possibleWay;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ways = s.solveNQueens(8);
        for (List<String> ss : ways) {
            for (String vs : ss) {
                System.out.println(vs);
            }
            System.out.println();
        }
    }

}
