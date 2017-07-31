package com.lei.leetcode.P219;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lei on 2017/7/21.
 */
public class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, -1};
        System.out.println(containsNearbyDuplicate(a, 1));
    }
}
