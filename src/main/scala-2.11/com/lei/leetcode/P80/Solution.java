package com.lei.leetcode.P80;

import com.lei.leetcode.Utils;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, ii = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                ii = i;
            } else if (ii == i) {
                i++;
                nums[i] = nums[j];
            }
        }
        Utils.displayList(Arrays.copyOfRange(nums, 0, i + 1));
        return i + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
        s.removeDuplicates(new int[]{0, 1, 2});
        s.removeDuplicates(new int[]{0, 0, 0});
        s.removeDuplicates(new int[]{0, 0, 0, 1});
        s.removeDuplicates(new int[]{0, 1, 1, 1, 1, 2});
        s.removeDuplicates(new int[]{0});

    }
}
