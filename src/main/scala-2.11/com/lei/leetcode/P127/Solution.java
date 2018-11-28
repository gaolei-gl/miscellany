package com.lei.leetcode.P127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        LinkedList<String> wordList2 = new LinkedList<>(wordList);
        wordList2.remove(beginWord);
        int i = 1;
        List<String> res = Arrays.asList(beginWord);
        while (!wordList2.isEmpty()) {
            res = findDistOne(res, wordList2);
            if (res.isEmpty()) return 0;
            wordList2.removeAll(res);
            i++;
            if (res.contains(endWord)) break;
        }
        return i;
    }

    private List<String> findDistOne(List<String> ss, LinkedList<String> wordList) {
        List<String> res = new LinkedList<>();
        for (String str : wordList) {
            for (String eachS : ss)
                if (isDistOne(str, eachS)) {
                    res.add(str);
                    break;
                }
        }
        return res;
    }

    private boolean isDistOne(String s, String t) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) n++;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(s.ladderLength("hot", "dog", Arrays.asList("hot", "dog")));
    }
}
