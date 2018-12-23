package com.lei.leetcode.P961;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>(A.length / 2 + 1);
        for (int a : A) {
            int n = map.getOrDefault(a, 0);
            map.put(a, n + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == A.length / 2) return entry.getKey();
        }
        return 0;
    }
}
