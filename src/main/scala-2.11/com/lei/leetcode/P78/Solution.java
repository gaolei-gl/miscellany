package com.lei.leetcode.P78;

import com.lei.leetcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> ls : ans) {
                ls.add(num);
                tmp.add(new ArrayList<>(ls));
                ls.remove(ls.size() - 1);
            }
            ans.addAll(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.subsets(new int[]{1, 2, 3, 4}));
    }
}

