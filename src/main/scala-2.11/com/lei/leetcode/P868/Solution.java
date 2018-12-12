package com.lei.leetcode.P868;

public class Solution {
    public int binaryGap(int N) {
        String binary = Integer.toBinaryString(N);
        int max = 0;
        int p1 = -1, p2 = -1;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                p2 = p1;
                p1 = i;
                if (p2 >= 0) {
                    max = Math.max(p1 - p2, max);
                }
            }
        }
        return max;
    }
}
