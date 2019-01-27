package com.lei.leetcode.P981;

import java.util.*;

public class TimeMap {
    Map<String, PriorityQueue<Entry>> map;

    private class Entry {
        String key;
        String value;

        public Entry(String key, String value, int ts) {
            this.key = key;
            this.value = value;
            this.ts = ts;
        }

        int ts;
    }

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        PriorityQueue<Entry> q = map.computeIfAbsent(key, a -> new PriorityQueue<>((e1, e2) -> Integer.compare(e2.ts, e1.ts)));
        q.offer(new Entry(key, value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        PriorityQueue<Entry> q = map.get(key);
        List<Entry> tmp = new ArrayList<>();
        while (!q.isEmpty() && q.peek().ts > timestamp) {
            tmp.add(q.poll());
        }
        if (q.isEmpty()) {
            q.addAll(tmp);
            return "";
        } else {
            Entry ans = q.peek();
            q.addAll(tmp);
            return ans.value;
        }
    }
}
