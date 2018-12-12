package com.lei.leetcode.P56;

import java.util.*;

public class Solution {
    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

        Stack<Interval> stack = new Stack<>();
        for (Interval interval : intervals) {
            if (stack.isEmpty()) stack.push(interval);
            else {
                if (stack.peek().end >= interval.start) {
                    Interval top = stack.pop();
                    top.end = Math.max(top.end, interval.end);
                    stack.push(top);
                } else {
                    stack.push(interval);
                }
            }
        }
        List<Interval> ans = new ArrayList<>(stack);
        return ans;
    }
}
