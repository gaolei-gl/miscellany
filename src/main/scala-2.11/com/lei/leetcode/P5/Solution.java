package com.lei.leetcode.P5;


public class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] reverse = new char[s.length()];
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            reverse[n - i - 1] = s.charAt(i);
            reverse[i] = s.charAt(n - i - 1);
        }

        int begin = 0, end = 0;
        int maxBegin = -1, maxEnd = -1, max = -1;
        int i = 0;
        while (i < n) {
            if (reverse[i] == s.charAt(i)) {
                begin = i;
                i++;
                while (i < n && reverse[i] == s.charAt(i)) i++;
                end = i - 1;

                if ((end - begin) > max) {
                    maxEnd = end;
                    maxBegin = begin;
                    max = end - begin;
                }
            } else {
                i++;
            }
        }
        if (maxEnd != -1)
            return s.substring(maxBegin, maxEnd + 1);
        else if (maxEnd == -1 && s.length() > 0) {
            return s.substring(s.length() - 1);
        } else
            return "";

    }

    public static void main(String[] args) {
        String data = "ab";
        System.out.println(longestPalindrome(data));

    }
}
