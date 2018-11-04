package com.lei.leetcode.P20;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        HashMap<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.keySet().contains(ch)) stack.push(map.get(ch));
            else {
                if (stack.empty()) return false;
                Character c = stack.pop();
                if (!c.equals(ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String ss[] = {
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
        };
        for (String s : ss)
            System.out.println(isValid(s));
    }
}
