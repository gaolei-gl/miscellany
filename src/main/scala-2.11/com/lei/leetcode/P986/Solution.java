package com.lei.leetcode.P986;

import com.lei.leetcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static private class Interval {
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

        @Override
        public String toString() {
            return start + " " + end;
        }
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A.length == 0 || B.length == 0) return new Interval[]{};
        List<Interval> ans = new ArrayList<>();
        int la = A.length;
        int lb = B.length;
        int i = 0, j = 0;
        while (i < la && j < lb) {
            Interval a = A[i];
            Interval b = B[j];
            if (a.end < b.start) {
                i++;
            } else if (b.end < a.start) {
                j++;
            } else if (a.start <= b.start && b.end <= a.end) {
                ans.add(b);
                j++;
            } else if (b.start <= a.start && a.end <= b.end) {
                ans.add(a);
                i++;
            } else if (a.start <= b.start && a.end <= b.end) {
                ans.add(new Interval(b.start, a.end));
                i++;
            } else if (b.start <= a.start && b.end <= a.end) {
                ans.add(new Interval(a.start, b.end));
                j++;
            }
        }
        return ans.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.intervalIntersection(new Interval[]{new Interval(0, 2), new Interval(5, 10)}, new Interval[]{new Interval(1, 5), new Interval(8, 12)}));
        Utils.displayList(s.intervalIntersection(new Interval[]{new Interval(5, 10)}, new Interval[]{new Interval(5, 6)}));

    }
}
