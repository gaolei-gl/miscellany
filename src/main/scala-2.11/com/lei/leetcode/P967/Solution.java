package com.lei.leetcode.P967;

import com.lei.leetcode.Utils;

import java.util.*;

public class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> pre = new ArrayList<>();
            pre.add(i);
            backTracking(res, pre, K, N);
        }
        return toArray(res);
    }

    private void backTracking(List<Integer> res, List<Integer> pre, int K, int N) {
        if (pre.size() == N) {
            res.add(toInt(pre));
            return;
        }
        if (pre.get(0) == 0) return;
        int last = pre.get(pre.size() - 1);
        if (last + K < 10) {
            pre.add(last + K);
            backTracking(res, pre, K, N);
            pre.remove(pre.size() - 1);
        }
        if (last - K >= 0 && K != 0) {
            pre.add(last - K);
            backTracking(res, pre, K, N);
            pre.remove(pre.size() - 1);
        }

    }

    private int[] toArray(List<Integer> l) {
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }

    private int toInt(List<Integer> ints) {
        int res = 0;
        int n = ints.size();
        for (int i = 0; i < n; i++) {
            res += ints.get(i) * Math.pow(10, n - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.numsSameConsecDiff(3, 7));
        Utils.displayList(s.numsSameConsecDiff(2, 0));
        Utils.displayList(s.numsSameConsecDiff(1, 0));

    }
}
