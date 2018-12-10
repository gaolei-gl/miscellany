package com.lei.leetcode.P433;

import java.util.*;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (!start.equals(end) && bank.length == 0) return -1;
        Set<String> banks = new HashSet<>(Arrays.asList(bank));
        if (!banks.contains(end)) return -1;
        banks.remove(start);
        int distance = 0;
        Set<String> seed = new HashSet<>(Collections.singletonList(start));
        while (!seed.isEmpty()) {
            Set<String> newSeed = new HashSet<>();
            distance++;
            for (String cur : seed) {
                Iterator<String> iter = banks.iterator();
                while (iter.hasNext()) {
                    String elem = iter.next();
                    if (distance(cur, elem) == 1) {
                        if (elem.equals(end)) return distance;
                        newSeed.add(elem);
                        iter.remove();
                    }
                }
            }
            seed = newSeed;
        }
        return -1;
    }

    private int distance(String s, String t) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
