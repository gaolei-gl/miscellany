package com.lei.leetcode.P553;

public class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        else if (nums.length == 2) return nums[0] + "/" + nums[1];
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]);
            sb.append("/(");
            for (int i = 1; i < nums.length; i++) {
                sb.append(nums[i]);
                sb.append("/");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            return sb.toString();
        }

    }
}
