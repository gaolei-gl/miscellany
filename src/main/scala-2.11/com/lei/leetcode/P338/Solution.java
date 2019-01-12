package com.lei.leetcode.P338;

public class Solution {

    /*
    利用之前计算过的结果，移位的做法很巧妙
     */
    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        else if (num == 1) return new int[]{0, 1};
        int max = 2;
        int[] result = new int[num + 1];
        result[1] = 1;
        for (int i = 2; i <= num; i++) {
            if ((i & (i - 1)) != 0) {
                result[i] = 1 + result[i - max];
            } else {
                result[i] = 1;
                max = i;
            }
        }
        return result;
    }
}
