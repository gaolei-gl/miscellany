package com.lei.leetcode.P367;

import java.util.Arrays;

/**
 * three way to do this.
 * Solution 1.
 * binary search, use target*target as condition
 * Solution 2.
 * Newton method
 * Solution 3.
 * Mathmatic trick
 * all perfect square number fall into form like this 1 + 3 + 5 + 7 + ....
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare1(4));
    }

    public static boolean isPerfectSquare1(int num) {
        int lo = 1, hi = num;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            int t = mid * mid;
            if (t == num) {
                return true;
            } else if (t < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }

    public static boolean isPerfectSquare2(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    public static boolean isPerfectSquare3(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        if (num == 0) {
            return true;
        }
        return false;
    }

}
