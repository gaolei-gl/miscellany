package com.lei.leetcode.P28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null)
            return -1;
        if (needle.equals(""))
            return 0;
        int[] pattern = new int[needle.length()];
        buildPattern(pattern, needle);
        for (int i = 0, j = 0; i < haystack.length() && j < needle.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length())
                    return i - j;
            } else if (j == 0) {
                i++;
            } else {
                j = pattern[j - 1];
            }
        }
        return -1;
    }

    public static void buildPattern(int[] pattern, String needle) {
        int count = 0;
        for (int i = 1; i < needle.length(); i++) {
            if (needle.charAt(count) == needle.charAt(i))
                pattern[i] = ++count;
            else {
                while (--count >= 0) {
                    if (needle.charAt(count) == needle.charAt(i)) {
                        count++;
                        break;
                    }
                }
                count = count < 0 ? 0 : count;
                pattern[i] = count;
            }
        }
    }
}
