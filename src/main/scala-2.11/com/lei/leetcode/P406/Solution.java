package com.lei.leetcode.P406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[people.length][];
        for (int[] p : people) {
            int cnt = p[1];
            int i = 0;
            while (cnt != 0) {
                if (res[i] == null || res[i][0] >= p[0]) cnt--;
                i++;
            }
            while (res[i] != null) i++;
            res[i] = p;
        }
        return res;
    }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (a, b) ->
                a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0])
        );
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reconstructQueue2(new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}

        });
    }
}
