package com.lei.leetcode.P202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum;
        while (inLoop.add(n)) {
            squareSum = nextNum(n);
            if (squareSum == 1)
                return true;
            else
                n = squareSum;
        }
        return false;
    }

    private int nextNum(int n) {
        int squareSum = 0, remain;
        while (n > 0) {
            remain = n % 10;
            squareSum += remain * remain;
            n /= 10;
        }
        return squareSum;
    }
}
