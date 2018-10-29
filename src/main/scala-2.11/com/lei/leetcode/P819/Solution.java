package com.lei.leetcode.P819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String str = paragraph.toLowerCase().replaceAll(",|!|\\?|'|;|\\.", " ");
        Set<String> set = new HashSet<>(banned.length);
        for (String s : banned) set.add(s);
        Map<String, Integer> map = new HashMap<>();
        for (String word : str.split(" ")) {
            if (!set.contains(word) && !word.equals("")) {
                int cnt = map.getOrDefault(word, 0);
                map.put(word, cnt + 1);
            }
        }
        int max = -1;
        String result = null;
        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(s);
    }
}