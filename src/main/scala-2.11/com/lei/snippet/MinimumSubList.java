package com.lei.snippet;

import com.lei.leetcode.Utils;

import java.util.*;

public class MinimumSubList {
    static class Interval {
        int start;
        int stop;

        public Interval(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }

    public List<Integer> f(String s) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        Map<Character, Integer> begin = new HashMap<>();
        Map<Character, Integer> end = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            begin.putIfAbsent(s.charAt(i), i);
            end.put(s.charAt(i), Math.max(end.getOrDefault(s.charAt(i), Integer.MIN_VALUE), i));
        }
        for (char c : begin.keySet()) pq.offer(new Interval(begin.get(c), end.get(c)));

        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Interval interval = pq.poll();
            hi = interval.stop;
            lo = interval.start;
            while (!pq.isEmpty() && hi > pq.peek().start) {
                interval = pq.poll();
                hi = Math.max(hi, interval.stop);
            }
            res.add(hi - lo + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumSubList obj = new MinimumSubList();
        Utils.displayList(obj.f("abcacbddefdmnm"));
        Utils.displayList(obj.f("aaa"));
        Utils.displayList(obj.f("caedbdedda"));
    }
}
