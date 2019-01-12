package com.lei.leetcode.P76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
//        if(s == null) return ""
        Map<Character, Integer> map = new HashMap<>();
        String res = "";
        int min = Integer.MAX_VALUE;
        for (char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int counter = map.size();
        int begin = 0, end = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) counter--;
            }
            end++;
            while (counter == 0) {
                char tmpc = s.charAt(begin);
                if (map.containsKey(tmpc)) {
                    map.put(tmpc, map.get(tmpc) + 1);
                    if (map.get(tmpc) > 0) {
                        counter++;
                        if (end - begin < min) {
                            min = end - begin;
                            res = s.substring(begin, end);
                        }
                    }
                }
                begin++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.minWindow("ADOBECODEBANC", "ABFC"));
        System.out.println(s.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
