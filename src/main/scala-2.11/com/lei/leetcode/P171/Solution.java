package com.lei.leetcode.P171;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int titleToNumber(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        char[] chars = s.toCharArray();
        char start = 'A';
        for (int i = 1; i <= 26; i++) {
            map.put(start, i);
            start += 1;
        }
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            ans += Math.pow(26, chars.length - i - 1) * map.get(chars[i]);
        }
        return ans;
    }
}
