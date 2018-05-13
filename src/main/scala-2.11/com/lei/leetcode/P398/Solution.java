package com.lei.leetcode.P398;

class Solution {
    public static char findTheDifference(String s, String t) {
        int letters[] = new int[26];
        for (char ch : s.toCharArray()) {
            letters[ch - 'a']++;
        }
        char result = ' ';
        for (char ch : t.toCharArray()) {
            if (--letters[ch - 'a'] < 0) {
                result = ch;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
