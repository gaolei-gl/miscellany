package com.lei.leetcode.P219;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lei on 2017/7/21.
 */
public class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i <= k) {
            set.add(nums[i++]);
        }
        if (set.size() < k) return true;
        while (i < nums.length) {
            set.remove(nums[i - k]);
            set.add(nums[i]);
            if (set.size() < k) return true;
            i++;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, -1};
        System.out.println(containsNearbyDuplicate(a, 1));
    }
}
