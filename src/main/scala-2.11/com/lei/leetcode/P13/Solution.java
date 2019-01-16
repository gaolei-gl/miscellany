package com.lei.leetcode.P13;

public class Solution {
    public int romanToInt(String s) {
        int res = 0;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }

        }
        if (s.contains("IV")) res -= 2;
        if (s.contains("IX")) res -= 2;
        if (s.contains("XL")) res -= 20;
        if (s.contains("XC")) res -= 20;
        if (s.contains("CD")) res -= 200;
        if (s.contains("CM")) res -= 200;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("IV"));
    }
}
