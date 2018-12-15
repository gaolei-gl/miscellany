package com.lei.leetcode.P494;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public int findTargetSumWays2(int[] nums, int S) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        for (int i = 0; i < nums.length; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Integer head = q.poll();
                q.add(head + nums[i]);
                q.add(head - nums[i]);
            }
        }
        int cnt = 0;
        for (int i : q) if (i == S) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(s.findTargetSumWays(new int[]{42, 24, 30, 14, 38, 27, 12, 29, 43, 42, 5, 18, 0, 1, 12, 44, 45, 50, 21, 47}, 38));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(s.findTargetSumWays2(new int[]{42, 24, 30, 14, 38, 27, 12, 29, 43, 42, 5, 18, 0, 1, 12, 44, 45, 50, 21, 47}, 38));
        System.out.println(System.currentTimeMillis() - start);
    }
}
