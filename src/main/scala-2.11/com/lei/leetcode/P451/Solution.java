package com.lei.leetcode.P451;

import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        int max = 0;
        Map<Integer, List<Character>> reverseMap = new HashMap<>(s.length());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            List<Character> l = reverseMap.getOrDefault(entry.getValue(), new ArrayList<>());
            max = Math.max(max, entry.getValue());
            l.add(entry.getKey());
            reverseMap.put(entry.getValue(), l);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = max; i >=0; i--) {
            if (!reverseMap.containsKey(i)) continue;
            List<Character> chars = reverseMap.get(i);
            for (Character ch : chars) {
                for (int t = 0; t < i; t++) sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.frequencySort("tree"));
        System.out.println(s.frequencySort("cccaaa"));
        System.out.println(s.frequencySort("Aabb"));
        System.out.println(s.frequencySort("./!ree"));
    }
}
