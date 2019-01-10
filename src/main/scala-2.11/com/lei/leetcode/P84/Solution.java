package com.lei.leetcode.P84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int pre = stack.pop();
                    max = Math.max(max, heights[pre] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int pre = stack.pop();
            max = Math.max(max, heights[pre] * (stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0}));
        /*
        [1,2,3,4,5,3,3,2]
[2,1,2]
[2,1,5,6,2,3]
[5,4,1,2]
[4,2,0,3,2,5]
[3,6,5,7,4,8,1,0]
         */
    }
}
