package com.lei.leetcode.P140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieTreeSolution {

    public static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    private TrieNode initial(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            add(root, word, 0);
        }
        return root;
    }

    private void add(TrieNode root, String word, int index) {
        if (index == word.length()) {
            root.isWord = true;
            return;
        }
        if (root.children[word.charAt(index) - 'a'] == null) {
            root.children[word.charAt(index) - 'a'] = new TrieNode();
        }
        add(root.children[word.charAt(index) - 'a'], word, index + 1);
        return;
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        TrieNode root = initial(wordDict);
        HashMap<String, List<String>> dp = new HashMap<>();
        return DFS(s, 0, root, dp);
    }

    private List<String> DFS(String s, int index, TrieNode root, HashMap<String, List<String>> dp) {
        if (index == s.length()) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        if (dp.containsKey(s.substring(index))) {
            return dp.get((s.substring(index)));
        }
        TrieNode forSearch = root;
        List<String> result = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            forSearch = forSearch.children[s.charAt(i) - 'a'];
            if (forSearch == null) {
                break;
            } else if (forSearch.isWord) {
                List<String> tmp = DFS(s, i + 1, root, dp);
                String prefix = s.substring(index, i + 1);
                for (String t : tmp) {
                    result.add(t.length() != 0 ? prefix + " " + t : prefix);
                }
            }
        }
        dp.put(s.substring(index), result);
        return result;
    }

}
