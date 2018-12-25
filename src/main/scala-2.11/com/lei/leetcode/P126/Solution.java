package com.lei.leetcode.P126;

import com.lei.leetcode.Utils;

import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        wordList.remove(beginWord);
        if (!wordList.contains(endWord)) return ans;
        Map<String, Set<String>> dict = build(beginWord, wordList);
        List<String> arr = new ArrayList<>();
        arr.add(beginWord);
        Queue<List<String>> q = new LinkedList<>();
        q.offer(arr);
        boolean findIt = false;
        while (!q.isEmpty() && !findIt) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<String> prefix = q.poll();
                for (String end : dict.getOrDefault(prefix.get(prefix.size() - 1), new HashSet<>())) {
                    List<String> t = new ArrayList<>(prefix);
                    t.add(end);
                    q.offer(t);
                    if (end.equals(endWord)) findIt = true;
                }
            }
        }
        for (List<String> candi : q) {
            if (!candi.isEmpty() && candi.get(candi.size() - 1).equals(endWord))
                ans.add(candi);
        }

        return ans;
    }

    private Map<String, Set<String>> build(String beginWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        List<String> all = new ArrayList<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> needRemove = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (String s : all) {
                    if (distance(s, cur) == 1) {
                        q.offer(s);
                        Set<String> ls = map.getOrDefault(cur, new HashSet<>());
                        ls.add(s);
                        map.put(cur, ls);
                        needRemove.add(s);
                    }
                }
            }
            all.removeAll(needRemove);
        }
        return map;
    }


    private int distance(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        Utils.displayList(s.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        List<String> data = new ArrayList<>(Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"));
        Utils.displayList(s.findLadders("red", "tax", data));
//        Utils.displayList(s.findLadders("hot", "dog", Arrays.asList("hot", "dog")));
    }

}
