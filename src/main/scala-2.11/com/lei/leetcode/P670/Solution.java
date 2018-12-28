package com.lei.leetcode.P670;

public class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumSwap(2736));
        System.out.println(s.maximumSwap(3295));
        System.out.println(s.maximumSwap(9523));
//        System.out.println(s.maximumSwap(2736));
    }
}
