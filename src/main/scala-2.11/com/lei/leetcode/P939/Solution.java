package com.lei.leetcode.P939;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) map.computeIfAbsent(p[0], a -> new HashSet<>()).add(p[1]);
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]), min);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
