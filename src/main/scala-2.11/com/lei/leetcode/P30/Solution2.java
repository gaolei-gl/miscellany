package com.lei.leetcode.P30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    won't work, hard to check whether the substring can be represented by the words.
 */
public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size();
        int begin = 0, end = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) count--;
            }
            end++;
            while (count == 0) {
                char tmpc = s.charAt(begin);
                if (map.containsKey(tmpc)) {
                    map.put(tmpc, map.get(tmpc) + 1);
                    if (map.get(tmpc) > 0) count++;
                }
                if (check(s.substring(begin, end), words)) res.add(begin);
                begin++;
            }
        }
        return res;
    }

    private boolean check(String s, String[] words) {
        return check(s, words, 0);
    }

    private boolean check(String s, String[] words, int idx) {
        if (s.equals("")) return true;
        if (idx >= words.length) return false;
        int index = s.indexOf(words[idx]);
        if (index != -1) {
            String left = s.substring(0, index);
            String right = s.substring(index + words[0].length());
            return check(left, words, idx + 1) && check(right, words, idx + 1);
        }
        return check(s, words, idx + 1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
//        System.out.println(s.findSubstring("abababab", new String[]{"ab", "ab", "ab"}));
        System.out.println(s.findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
    }
}
