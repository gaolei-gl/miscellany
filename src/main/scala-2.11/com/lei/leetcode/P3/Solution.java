package com.lei.leetcode.P3;

import com.lei.leetcode.Utils;

import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        int[] max = new int[s.length()];
        char[] chars = s.toCharArray();
        max[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            int idx = find(chars, i, c);
            if (idx == -1) max[i] = max[i - 1] + 1;
            else {
                max[i] = i - idx > max[i - 1] ? max[i - 1] + 1 : i - idx;
            }
        }
        Arrays.sort(max);
        return max[max.length - 1];
    }

    private int find(char[] chars, int end, char c) {
        int i = end - 1;
        while (i >= 0) {
            if (chars[i] == c) break;
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("a"));
        System.out.println(s.lengthOfLongestSubstring(""));
    }
}
