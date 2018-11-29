package com.lei.leetcode.P692;

import com.lei.leetcode.Utils;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int n = map.getOrDefault(word, 0);
            map.put(word, n + 1);
        }
        Map<Integer, List<String>> reverseMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            String str = entry.getKey();
            if (!reverseMap.containsKey(cnt)) {
                reverseMap.put(cnt, new LinkedList<>());
            }
            reverseMap.get(cnt).add(str);
        }
        List<String> res = new LinkedList<>();
        for (Map.Entry<Integer, List<String>> entry : reverseMap.entrySet()) {
            List<String> ls = entry.getValue();
            Collections.sort(ls);
            res.addAll(ls);
        }
        return res.subList(0, k);
    }

    public static void main(String[] args) {
        String[] t1 = new String[]{"i", "love", "it", "i", "love", "coding"};
        String[] t2 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        Solution s = new Solution();
        Utils.displayList(s.topKFrequent(t1, 2));
        Utils.displayList(s.topKFrequent(t2, 4));
    }
}
