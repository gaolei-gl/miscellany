package com.lei.leetcode.P279;

import java.util.*;

public class Solution {

    public int numSquares(int n) {
        List<Integer> sqrts = getSqrts(n);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.offer(n);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int time = 0; time < size; time++) {
                int num = q.poll();
                if (!seen.add(num)) continue;
                for (int sqrt : sqrts) {
                    if (num - sqrt == 0) return level;
                    else if (num - sqrt < 0) break;
                    else {
                        q.offer(num - sqrt);
                    }
                }
            }
        }
        return level;
    }

    private List<Integer> getSqrts(int n) {
        int j = 1;
        List<Integer> s = new ArrayList<>();
        while (j * j <= n) {
            s.add(j * j);
            j++;
        }
        return s;
    }
}
