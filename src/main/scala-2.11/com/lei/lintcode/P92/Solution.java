package com.lei.lintcode.P92;


public class Solution {
    /**
     * @param spaceCnt: An integer m denotes the size of a backpack
     * @param A:        Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack(int spaceCnt, int[] A) {

        int lengthA = A.length;
        int[][] dp = new int[lengthA][spaceCnt + 1];
        for (int i = 0; i < lengthA; i++) {
            for (int j = 1; j <= spaceCnt; j++) {
                if (A[i] > j) {
                    if (i == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = A[i];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], A[i] + dp[i - 1][j - A[i]]);
                    }
                }
            }

        }

        for (int[] s : dp) {
            for (int ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }
        return dp[A.length - 1][spaceCnt];
    }

    public static void main(String[] args) {
//        System.out.println(backPack(10, new int[]{3, 4, 8, 5}));
        System.out.println(backPack(90, new int[]{12, 3, 7, 4, 5, 13, 2, 8, 4, 7, 6, 5, 7}));
    }
}