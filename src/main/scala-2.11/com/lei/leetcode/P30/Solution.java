package com.lei.leetcode.P30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) return ans;

        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) cnt.put(w, 1 + cnt.getOrDefault(w, 0));

        final int wl = words[0].length();
        for (int i = 0; i < wl; i++) { // run sliding window wl times
            int l = i;
            int r = i; // s[l,r) contains only words
            Map<String, Integer> window = new HashMap<>();
            int windowCnt = 0;

            while (r + wl <= s.length()) {
                final String w = s.substring(r, r + wl);
                r += wl;
                window.put(w, 1 + window.getOrDefault(w, 0));
                windowCnt++;

                while (window.getOrDefault(w, 0) > cnt.getOrDefault(w, 0)) {
                    final String leadingWord = s.substring(l, l + wl);
                    window.put(leadingWord, window.get(leadingWord) - 1);
                    l = l + wl;
                    windowCnt--;
                }

                if (windowCnt == words.length) ans.add(l);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(s.findSubstring("abababab", new String[]{"ab", "ab", "ab"}));
    }
}
