package com.lei.leetcode.P456;

import java.util.Stack;

public class Solution {

    class Pair {
        int min, max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty() || stack.peek().min > num) stack.push(new Pair(num, num));
            else if (num > stack.peek().min) {
                Pair last = stack.pop();
                if (last.max > num) return true;
                else {
                    last.max = num;
                    while (!stack.isEmpty() && stack.peek().max <= num) stack.pop();
                    if (!stack.isEmpty() && stack.peek().min < num) return true;
                    stack.push(last);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.find132pattern(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(s.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(s.find132pattern(new int[]{6, 12, 3, 4, 6, 11, 20}));
//        System.out.println(s.find132pattern(new int[]{-1, 3, 2, 0}));
    }
}
