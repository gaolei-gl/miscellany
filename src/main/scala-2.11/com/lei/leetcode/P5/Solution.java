package com.lei.leetcode.P5;


public class Solution {
    int max = 0, begin = 0, end = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        for (int i = 0; i < s.length(); i++) {
            // for odd
            extendPalidrome(s, i, i);
            // for even
            extendPalidrome(s, i, i + 1);
        }

        return s.substring(begin, end + 1);
    }

    private void extendPalidrome(String s, int x, int y) {
        while (x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y)) {
            x--;
            y++;
        }

        if (y - x - 1 >= max) {
            max = y - x - 1;
            begin = x + 1;
            end = y - 1;
        }
    }

    public static void main(String[] args) {
        String data = "ac";
        Solution s = new Solution();
        System.out.println(s.longestPalindrome(data));

    }
}
