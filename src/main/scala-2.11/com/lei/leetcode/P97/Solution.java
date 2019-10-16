package com.lei.leetcode.P97;

import com.lei.leetcode.Utils;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int start, int n, int k) {
        if (0 == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            helper(res, cur, i + 1, n, k - 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.combine(5, 3));
        Utils.displayList(s.combine(4, 2));
    }
}
