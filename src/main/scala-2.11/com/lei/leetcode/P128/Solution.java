package com.lei.leetcode.P128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) set.add(n);

        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int curLength = 1;
                int cur = n;
                while (set.contains(cur + 1)) {
                    curLength++;
                    cur += 1;
                }
                longest = Math.max(longest, curLength);
            }
        }
        return longest;
    }
}
