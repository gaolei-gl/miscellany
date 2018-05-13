package com.lei.leetcode.P383;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            if (dict.containsKey(ch)) {
                dict.put(ch, dict.get(ch) + 1);
            } else {
                dict.put(ch, 1);
            }
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!dict.containsKey(ch)) {
                return false;
            }
            int cnt = dict.get(ch);
            if (cnt < 1) {
                return false;
            }
            dict.put(ch, cnt - 1);
        }

        return true;

    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
