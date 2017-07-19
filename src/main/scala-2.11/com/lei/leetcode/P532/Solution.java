package com.lei.leetcode.P532;

import scala.Int;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lei on 2017/7/15.
 */
public class Solution {
    public static int findPairs(int[] nums, int k) {
        int min = min(nums);
        if (min < 0) {
            for (int i = 0; i < nums.length; i++) nums[i] -= min;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (k == 0 && entry.getValue() > 1) cnt++;
            else if (k != 0 && map.containsKey(key + k) && map.get(key + k) > 0) cnt++;
        }
        return cnt;

    }

    public static int find(int[] nums, int target, int start) {
        while (start < nums.length - 1) {
            if (nums[start] == target)
                return start;
        }
        return -1;
    }

    public static int min(int[] nums) {
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{3, 1, 4, 1, 5};
//        System.out.println(findPairs(a, 2));
//        int[] a = new int[]{1,2,3,4,5};
//        System.out.println(findPairs(a, 1));
        int[] a = new int[]{};


        System.out.println(findPairs(a, 394));
    }
}
