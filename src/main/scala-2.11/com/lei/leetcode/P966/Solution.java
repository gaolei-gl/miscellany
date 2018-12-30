package com.lei.leetcode.P966;

import com.lei.leetcode.Utils;

import java.util.*;

public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, Integer> caseInSensitiveMap = new HashMap<>(wordlist.length);
        for (int i = wordlist.length - 1; i >= 0; i--) caseInSensitiveMap.put(wordlist[i].toLowerCase(), i);
        Map<String, String> vowelMap = new HashMap<>(wordlist.length);
        for (int i = wordlist.length - 1; i >= 0; i--) {
            vowelMap.put(transfer(wordlist[i]), wordlist[i]);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = helper(caseInSensitiveMap, vowelMap, wordSet, queries[i], wordlist);
        }
        return res;
    }

    private String helper(Map<String, Integer> caseInSensitiveMap, Map<String, String> vowelMap, Set<String> wordSet, String query, String[] wordList) {
        if (wordSet.contains(query)) return query;
        else if (caseInSensitiveMap.containsKey(query.toLowerCase()))
            return wordList[caseInSensitiveMap.get(query.toLowerCase())];
        else if (vowelMap.containsKey(transfer(query))) return vowelMap.get(transfer(query));
        return "";
    }

    private String transfer(String s) {
        return s.toLowerCase().replaceAll("a", ".").replaceAll("e", ".").replaceAll("i", ".").replaceAll("o", ".").replaceAll("u", ".");
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] wordList = new String[]{"wg", "uo", "as", "kv", "ra", "mw", "gi", "we", "og", "zu"};
        String[] queries = new String[]{"AS", "in", "yc", "kv", "mw", "ov", "lc", "os", "wm", "Mw"};
//        "kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"
        Utils.displayList(s.spellchecker(wordList, queries));
    }
}
