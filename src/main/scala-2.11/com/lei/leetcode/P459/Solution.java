package com.lei.leetcode.P459;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abba"));
    }
}
