package com.lei.leetcode.P763;

import java.util.*;

public class Solution {
    static class Duration implements Comparable<Duration> {
        public char ch;
        public int start;
        public int stop;

        public Duration(char ch, int start, int stop) {
            this.ch = ch;
            this.start = start;
            this.stop = stop;
        }


        @Override
        public int compareTo(Duration o) {
            return this.start - o.start;
        }
    }

    private static int getEnd(int end, List<Duration> durations) {
        for (Duration d : durations) {
            if (d.start <= end && d.stop > end) {
                end = d.stop;
            }
        }
        return end;
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Duration> map = new HashMap<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char ch = S.charAt(i);
            if (map.containsKey(ch)) {
                Duration d = map.get(ch);
                d.stop = i;
                map.put(ch, d);
            } else {
                Duration d = new Duration(ch, i, i);
                map.put(ch, d);
            }
        }
        List<Duration> sortedDuration = new ArrayList(map.values().size());
        sortedDuration.addAll(map.values());
        Collections.sort(sortedDuration);

        // 9 7 8

        int end = sortedDuration.get(0).stop;
        int start = 0;
        while (end < length) {
            int newEnd = getEnd(end, sortedDuration);
            int len = newEnd - start + 1;
            result.add(len);
            start = newEnd + 1;
            end = newEnd + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String demo = "caedbdedda";
        for (int i : partitionLabels(demo)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
