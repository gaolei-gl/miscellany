package com.lei.leetcode.P122;

/**
 * Created by Lei on 2017/8/10.
 */
public class Solution {
    public static int maxProfit(int[] p) {
        int low = 0, sum = 0, agg = 0;
        for (int i = 0; i < p.length - 1; i++) {
            if (p[i] < p[i + 1]) {
                agg = p[i + 1] - p[low];
            } else {
                sum += agg;
                agg = 0;
                low = i + 1;
            }
        }
        sum += agg;
        return sum;
    }

    public static void main(String[] args) {
//        int[] p = new int[]{6, 1, 3, 2, 4, 7};
//        int[] p = new int[]{1, 2, 3, 4, 5};
        int[] p = new int[]{5, 4, 3, 2, 1};
        System.out.println(maxProfit(p));
    }
}
