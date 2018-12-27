package com.lei.leetcode.P491;

import com.lei.leetcode.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, 0, new ArrayList<>(), nums);
        return ans;
    }

    private void backTracking(List<List<Integer>> ans, int start, List<Integer> prefix, int[] nums) {
        if (prefix.size() >= 2) {
            ans.add(new ArrayList<>(prefix));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (!prefix.isEmpty() && nums[i] < prefix.get(prefix.size() - 1)) continue;
            prefix.add(nums[i]);
            used.add(nums[i]);
            backTracking(ans, i + 1, prefix, nums);
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1}));
        Utils.displayList(s.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
