package com.lei.leetcode.P47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(res, new ArrayList<>(), nums, used);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> prefix, int[] nums, boolean[] used) {
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<>(prefix));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                prefix.add(nums[i]);
                backtracking(res, prefix, nums, used);
                used[i] = false;
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (List<Integer> l : s.permuteUnique(new int[]{1, 1, 2})) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
