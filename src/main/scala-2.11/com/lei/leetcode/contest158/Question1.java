package com.lei.leetcode.contest158;

public class Question1 {
    public int balancedStringSplit(String s) {
        int l = 0, r = 0, n = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                r++;
            } else {
                l++;
            }
            if (l > 0 && r > 0 && l == r) {
                n++;
                l = 0;
                r = 0;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Question1 s = new Question1();
        System.out.println(s.balancedStringSplit("LLLRLRL"));
    }
}
