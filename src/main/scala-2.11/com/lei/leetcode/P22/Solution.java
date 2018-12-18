package com.lei.leetcode.P22;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", n, n);
        return res;
    }

    private void backTrack(List<String> res, String prefix, int left, int right) {
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(prefix);
            return;
        }
        if (left < right) {
            backTrack(res, prefix + ")", left, right - 1);
        }
        backTrack(res, prefix + "(", left - 1, right);
    }
}
