package com.lei.leetcode.P139;

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Character> set = new HashSet<>();
        for (String word : wordDict) {
            for (char c : word.toCharArray()) set.add(c);
        }
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) return false;
        }
        Collections.sort(wordDict, (o1, o2) -> o2.length() - o1.length());
        boolean[] flags = new boolean[s.length()];
        Arrays.fill(flags, true);
        return breaker(s, wordDict, flags);
    }

    private boolean breaker(String s, List<String> wordDict, boolean[] flags) {
        if (s == null || s.isEmpty()) return true;
        if (!flags[s.length() - 1]) return false;
        List<String> possible = new ArrayList<>();
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                possible.add(word);
            }
        }
        if (possible.isEmpty()) return false;
        boolean foundIt = false;
        for (String prefix : possible) {
            foundIt = breaker(s.substring(prefix.length()), wordDict, flags);
            if (foundIt) break;
        }
        flags[s.length() - 1] = foundIt;
        return foundIt;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa", "ba")));
    }
}
