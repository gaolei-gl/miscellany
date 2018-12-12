package com.lei.leetcode.P140;

import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        return backtracking(s, wordDict, memo);
    }

    private List<String> backtracking(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = backtracking(s.substring(word.length()), wordDict, memo);
                for (String sub : subList)
                    ans.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        memo.put(s, ans);
        return ans;
    }
}

