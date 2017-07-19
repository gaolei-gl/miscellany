package com.lei.leetcode.P448;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei on 2017/7/19.
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                a.add(i + 1);
            }
        }
        return a;

    }

    public static void main(String[] args) {

    }
}
