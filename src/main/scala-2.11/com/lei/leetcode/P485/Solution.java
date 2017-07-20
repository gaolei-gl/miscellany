package com.lei.leetcode.P485;

/**
 * Created by Lei on 2017/7/19.
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;
        for (int i : nums) {
            max = Math.max(max, currentMax = i == 0 ? 0 : currentMax + 1);
        }
        return max;
    }
}
