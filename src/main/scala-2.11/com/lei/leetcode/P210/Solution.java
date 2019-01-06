package com.lei.leetcode.P210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> solved = new HashSet<>(numCourses);
        for (int i = 0; i < numCourses; i++) solved.add(i);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            List<Integer> l = map.getOrDefault(pre[0], new ArrayList<>());
            l.add(pre[1]);
            map.put(pre[0], l);
            solved.remove(pre[0]);
        }
        List<Integer> ans = new ArrayList<>(solved);
        while (!map.isEmpty()) {
            Set<Integer> toAdd = new HashSet<>();
            for (Integer course : solved) {
                for (Integer key : map.keySet()) {
                    map.get(key).remove(course);
                    if (map.get(key).isEmpty()) {
                        toAdd.add(key);
                        ans.add(key);
                    }
                }
                for (Integer key : toAdd) map.remove(key);
            }
            if (toAdd.isEmpty()) return new int[]{};
            solved = toAdd;
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) res[i] = ans.get(i);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findOrder(3, new int[][]{{1, 0}});
    }
}
