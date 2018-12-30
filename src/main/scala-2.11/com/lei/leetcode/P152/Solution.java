package com.lei.leetcode.P152;

public class Solution {
    public int maxProduct(int[] A) {
        if (A.length == 1) return A[0];
        int max = A[0];
        int dpMax = A[0];
        int dpMin = A[0];
        for (int i = 1; i < A.length; i++) {
            int k = dpMax * A[i];
            int m = dpMin * A[i];
            dpMax = Math.max(A[i], Math.max(k, m));
            dpMin = Math.min(A[i], Math.min(k, m));
            max = Math.max(dpMax, max);
        }
        return max;
    }
}
