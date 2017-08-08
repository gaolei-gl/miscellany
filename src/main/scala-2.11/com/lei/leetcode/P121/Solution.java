package com.lei.leetcode.P121;

/**
 * Created by Lei on 2017/8/7.
 */
public class Solution {
    public static void main(String[] args) {
//        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        int[] a = new int[]{2, 4, 1};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

}
