package com.lei.leetcode.P380;

import java.util.*;

public class RandomizedSet {
    /**
     * Initialize your data structure here.
     */
    Map<Integer, Integer> map;
    List<Integer> list;
    Set<Integer> invalid;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
        invalid = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.remove(val);
        list.set(idx, null);
        invalid.add(idx);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        while (invalid.contains(idx)) idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
