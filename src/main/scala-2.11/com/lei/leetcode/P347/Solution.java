package com.lei.leetcode.P347;

import java.util.*;

//
//Given a non-empty array of integers, return the k most frequent elements.
//Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Integer key : map.keySet()) q.offer(key);
        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) ans.add(q.poll());
        return ans;
    }
}
