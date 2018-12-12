package com.lei.leetcode.P378;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //[lo, hi)
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (lo < hi) {
            int count = 0;
            int mid = lo + (hi - lo) / 2;
            int j = matrix[0].length - 1;
            for (int[] aMatrix : matrix) {
                while (j >= 0 && aMatrix[j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}