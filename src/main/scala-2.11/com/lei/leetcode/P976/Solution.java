package com.lei.leetcode.P976;


import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int l1 = len - 3, l2 = len - 2, l3 = len - 1;
        while (l1 >= 0) {
            if (A[l1] + A[l2] > A[l3]) return A[l1] + A[l2] + A[l3];
            l1--;
            l2--;
            l3--;
        }
        return 0;
    }
}
