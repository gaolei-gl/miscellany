package com.lei.leetcode.P438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (char ch : p.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
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
                if (end - begin == p.length()) res.add(begin);
                begin++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}
