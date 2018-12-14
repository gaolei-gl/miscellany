package com.lei.leetcode.P150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    Stack<String> stack;
    Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        stack = new Stack<>();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (operators.contains(tokens[i])) {
                stack.push(tokens[i]);
                continue;
            }
            if (!stack.isEmpty() && !operators.contains(stack.peek())) {
                String ans = calculate(tokens[i], stack.pop(), stack.pop());
                while (!stack.isEmpty() && !operators.contains(stack.peek())) {
                    ans = calculate(ans, stack.pop(), stack.pop());
                }
                stack.push(ans);
            } else {
                stack.push(tokens[i]);
            }
        }
//        while (stack.size() != 1) stack.push(calculate(stack.pop(), stack.pop(), stack.pop()));
        return Integer.parseInt(stack.pop());

    }

    private String calculate(String x, String y, String operator) {
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        switch (operator) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            default:
                return String.valueOf(a / b);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        System.out.println(s.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
