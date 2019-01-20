package com.lei.leetcode.P978;

public class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A.length == 0) return 0;
        int max = 1;
        int[] greater = new int[A.length];
        int[] less = new int[A.length];
        greater[0] = 1;
        less[0] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                greater[i] = less[i - 1] + 1;
                less[i] = 1;
                max = Math.max(greater[i], max);
            } else if (A[i] < A[i - 1]) {
                less[i] = greater[i - 1] + 1;
                greater[i] = 1;
                max = Math.max(max, less[i]);
            } else {
                greater[i] = 1;
                less[i] = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(s.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(s.maxTurbulenceSize(new int[]{100}));
    }
}
