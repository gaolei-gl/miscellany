package com.lei.leetcode.P46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> mix(List<List<Integer>> data, int val) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j <= data.get(i).size(); j++) {
                List<Integer> round = new ArrayList<>(data.get(i));
                round.add(j, val);
                r.add(round);
            }
        }
        return r;
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            ArrayList<List<Integer>> r = new ArrayList<>();
            r.add(Arrays.asList(nums[0]));
            return r;
        } else if (nums.length == 0) {
            return new ArrayList<>();
        } else {
            ArrayList<List<Integer>> result = new ArrayList<>();
            int[] d = Arrays.copyOfRange(nums, 1, nums.length);
            int elem = nums[0];
            List<List<Integer>> restPermute = permute(d);
            result.addAll(mix(restPermute, elem));
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> l = s.permute(new int[]{1, 2, 3});
        for (List<Integer> ls : l) {
            for (int i : ls) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}