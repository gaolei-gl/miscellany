package com.lei.leetcode.P42;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    Stack<Integer> stack;

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        stack = new Stack<>();
        int idx = 0;
        int ans = 0;
        List<Integer> popedItems = new ArrayList<>();
        while (idx < height.length && height[idx] == 0) idx++;
        for (; idx < height.length; idx++) {
            if (stack.isEmpty() || height[idx] <= stack.peek()) stack.push(height[idx]);
            else {
                popedItems.clear();
                while (!stack.isEmpty() && stack.peek() <= height[idx]) popedItems.add(stack.pop());
                int max = stack.empty() ? popedItems.get(popedItems.size() - 1) : height[idx];
                for (int each : popedItems) ans += max - each;
                if (!stack.isEmpty()) for (int each : popedItems) stack.push(max);
                stack.push(height[idx]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(s.trap(new int[]{1}));
        System.out.println(s.trap(new int[]{3, 2, 1}));
        System.out.println(s.trap(new int[]{}));
        System.out.println(s.trap(new int[]{0}));
        System.out.println(s.trap(new int[]{4, 2, 3}));
    }
}
