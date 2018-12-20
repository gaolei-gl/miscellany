package com.lei.leetcode.P207;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> ls = map.getOrDefault(prerequisite[0], new HashSet<>());
            ls.add(prerequisite[1]);
            map.put(prerequisite[0], ls);
        }
        Set<Integer> allCourses = new HashSet<>(numCourses);
        for (int i = 0; i < numCourses; i++) allCourses.add(i);
        allCourses.removeAll(map.keySet());
        if (allCourses.isEmpty()) return false;
        while (!map.isEmpty()) {
            Set<Integer> keys = map.keySet();
            for (int course : keys) {
                Set<Integer> pre = map.get(course);
                pre.removeAll(allCourses);
                if (pre.isEmpty()) allCourses.add(course);
            }
            boolean removeSomeKeys = keys.removeAll(allCourses);
            if (!removeSomeKeys) return false;
            for (Integer k : allCourses) map.remove(k);
        }
        return true;
    }
}
