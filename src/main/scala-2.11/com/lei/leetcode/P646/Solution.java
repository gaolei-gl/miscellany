package com.lei.leetcode.P646;

import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * Given a set of pairs, find the length longest chain which can be formed.
 * You needn't use up all the given pairs. You can select pairs in any order.
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        int length = 0;
        if (pairs == null || pairs.length == 0) return length;
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[1] - o2[1] != 0) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (end < pair[0]) {
                end = pair[1];
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testData = new int[][]{
                {5, 8},
                {3, 4},
                {7, 8},
                {6, 7},
        };
        System.out.println(solution.findLongestChain(testData));
        System.out.println();
    }
}
