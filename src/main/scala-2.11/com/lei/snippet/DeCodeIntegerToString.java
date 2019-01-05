package com.lei.snippet;

import com.lei.leetcode.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeCodeIntegerToString {
    Map<Integer, Character> dict;
    char[] nums;
    List<String> ans;

    public DeCodeIntegerToString() {
        dict = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            dict.put(c - 'a' + 1, c);
        }
        ans = new ArrayList<>();
    }

    public List<String> decode(int N) {
        nums = String.valueOf(N).toCharArray();
        helper("", 0);
        return ans;
    }

    private void helper(String pre, int idx) {
        if (idx == nums.length) ans.add(pre);
        else {
            pre += dict.get(Integer.parseInt(String.valueOf(nums[idx])));
            helper(pre, idx + 1);
            pre = pre.substring(0, pre.length() - 1);
            if (idx + 1 < nums.length) {
                int a = Integer.parseInt(String.valueOf(nums[idx]) + nums[idx + 1]);
                if (dict.containsKey(a)) {
                    pre += dict.get(a);
                    helper(pre, idx + 2);
                }
            }

        }
    }


    public static void main(String[] args) {
        DeCodeIntegerToString obj = new DeCodeIntegerToString();
        Utils.displayList(obj.decode(16));
    }

}
