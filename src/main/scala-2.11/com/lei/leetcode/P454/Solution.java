package com.lei.leetcode.P454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) return 0;
        int N = A.length;
        Map<Integer, Integer> firstPart = new HashMap<>(N * N);
        Map<Integer, Integer> secondPart = new HashMap<>(N * N);
        buildMap(A, B, firstPart);
        buildMap(C, D, secondPart);
        int ans = 0;
        for (int key : firstPart.keySet()) {
            if (secondPart.containsKey(-key)) {
                ans += firstPart.get(key) * secondPart.get(-key);
            }
        }
        return ans;

    }

    private void buildMap(int[] A, int[] B, Map<Integer, Integer> firstPart) {
        for (int a : A) {
            for (int b : B) {
                int cnt = firstPart.getOrDefault(a + b, 0);
                firstPart.put(a + b, cnt + 1);
            }
        }
    }
}
