package com.lei.leetcode.P55;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
//        return topDown(nums, 0, new HashMap<>());
        boolean[] cache = new boolean[nums.length];
        cache[nums.length - 1] = true;
        bottomUp(nums, cache);
        return cache[0];
    }


    private void bottomUp(int[] nums, boolean[] cache) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                cache[i] = false;
            } else {
                for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                    if (cache[i + j]) {
                        cache[i] = true;
                        break;
                    }
                }
            }
        }
    }

    /*
        TLE: top-down
     */
    private boolean topDown(int[] nums, int idx, Map<Integer, Boolean> cache) {
        if (cache.containsKey(idx)) return cache.get(idx);
        if (idx >= nums.length) return false;
        if (idx == nums.length - 1) return true;
        boolean doable = false;
        for (int i = 1; i <= nums[idx]; i++) {
            doable = topDown(nums, idx + i, cache);
            if (doable) break;
        }
        cache.put(idx, doable);
        return doable;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2, 5, 0, 0}));
        System.out.println(s.canJump(new int[]{0}));
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
