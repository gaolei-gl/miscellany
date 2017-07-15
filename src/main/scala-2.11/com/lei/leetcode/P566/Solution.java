package com.lei.leetcode.P566;

/**
 * Created by Lei on 2017/7/15.
 */
public class Solution {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int height = nums.length;
        int width = nums[0].length;
        if (height * width != r * c) return nums;

        int[][] a = new int[r][c];
        for (int i = 0; i < r; i++) a[i] = new int[c];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                a[(i * width + j) / c][(i * width + j) % c] = nums[i][j];
            }
        }
        return a;

    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}};
        int[][] b = matrixReshape(a, 2, 2);
        System.out.println(b);
    }
}
