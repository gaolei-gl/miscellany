package com.lei.leetcode.P953;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), (char) ('a' + i));
        }
        String[] translate = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            translate[i] = convert(words[i], map);
        }
        String[] unorder = Arrays.copyOf(translate, translate.length);
        Arrays.sort(translate);
        return Arrays.equals(unorder, translate);
    }

    private String convert(String s, Map<Character, Character> map) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            sb.append(map.get(ch));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.isAlienSorted(new String[]{
                "kuvp", "q"
        }, "ngxlkthsjuoqcpavbfdermiywz");
        System.out.println(b);
    }
}

