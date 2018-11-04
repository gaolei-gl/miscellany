package com.lei.leetcode.P438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) return l;
        int lengthP = p.length();
        int lengths = s.length();
        if (lengthP > lengths) return l;
        int[] counter = new int[26];
        for (Character ch : p.toCharArray()) {
            counter[ch - 'a'] += 1;
        }
        char[] sArray = s.toCharArray();
        for (int i = 0; i <= lengths - lengthP; i++) {
            if (diff(counter, Arrays.copyOfRange(sArray, i, i + lengthP))) {
                l.add(i);
            }
        }

        return l;
    }

    private static boolean diff(int[] counter, char[] subStr) {
        int[] subCnt = new int[26];
        for (int i = 0; i < subStr.length; i++) {
            subCnt[subStr[i] - 'a'] += 1;
        }

        return Arrays.equals(counter, subCnt);
    }

    public static void main(String[] args) {
        String s = "bca";
        String p = "abc";
        for (int i : findAnagrams(s, p)) {
            System.out.println(i);
        }
    }
}
