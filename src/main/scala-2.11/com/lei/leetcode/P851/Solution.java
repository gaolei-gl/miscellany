package com.lei.leetcode.P851;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
    int[] res;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        for (int i = 0; i < n; i++) richer2.put(i, new ArrayList<>());
        for (int[] r : richer) richer2.get(r[1]).add(r[0]);
        res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) dfs(i, quiet);
        return res;
    }

    private int dfs(int i, int[] quiet) {
        if (res[i] != -1) return res[i];
        res[i] = i;
        for (int n : richer2.get(i)) {
            int m = dfs(n, quiet);
            if (quiet[res[i]] > quiet[res[m]]) res[i] = res[m];
        }
        return res[i];
    }
}
