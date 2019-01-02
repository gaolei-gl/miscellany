package com.lei.snippet;

import com.lei.leetcode.Utils;

import java.util.*;

public class TopKFrequencyWord {
    public List<String> topKWord(String str, String[] blackList, int k) {
        Set<String> blackSet = new HashSet<>(blackList.length);
        for (String w : blackList) blackSet.add(w.toLowerCase());
        blackSet.add(" ");
        String[] words = str.toLowerCase().replaceAll("\\W", " ").replaceAll("\\d", "").split(" ");
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            if (!blackSet.contains(w))
                cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<String> q = new PriorityQueue<>((s1, s2) -> {
            if (cnt.get(s2).compareTo(cnt.get(s1)) == 0) return s1.compareTo(s2);
            return cnt.get(s2).compareTo(cnt.get(s1));
        });
        for (String w : cnt.keySet()) q.offer(w);
        List<String> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) res.add(q.poll());
        return res;
    }

    public static void main(String[] args) {
        TopKFrequencyWord obj = new TopKFrequencyWord();
        Utils.displayList(obj.topKWord("Jack and Jill went to the market to buy bread a1n2d cheese. Cheese is Jack's and Jill's favorite food.", new String[]{"and", "he", "the", "to", "is", "Jack", "Jill"}, 2));
    }
}
