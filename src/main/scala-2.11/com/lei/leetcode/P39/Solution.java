package com.lei.leetcode.P39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        backtracking(res, prefix, candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> prefix, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(prefix));
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                prefix.add(candidates[i]);
                backtracking(res, prefix, candidates, target - candidates[i], i);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

}
