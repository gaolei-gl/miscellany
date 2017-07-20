package com.lei.leetcode.P414;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Lei on 2017/7/20.
 */
public class Solution {
    public static int thirdMax(int[] nums) {
        Integer max1, max2, max3;
        max1 = max2 = max3 = null;
        for (Integer p : nums) {
            if (p.equals(max1) || p.equals(max2) || p.equals(max3)) continue;
            if (max1 == null || max1 < p) {
                max3 = max2;
                max2 = max1;
                max1 = p;
            } else if (max2 == null || max2 < p) {
                max3 = max2;
                max2 = p;
            } else if (max3 == null || max3 < p) {
                max3 = p;
            }
        }

        return max3 == null ? max1 : max3;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(a));
    }
}
