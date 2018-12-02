package com.lei.leetcode.P90;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> prefix, int[] nums, int idx) {
        res.add(new ArrayList<>(prefix));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            prefix.add(nums[i]);
            backtracking(res, prefix, nums, i + 1);
            prefix.remove(prefix.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
