package com.lei.leetcode.P316;

import java.util.*;

public class Solution {
    Stack<Character> stack;

    public String removeDuplicateLetters(String s) {
        stack = new Stack<>();
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : chars) cnt[c - 'a']++;
        boolean[] visited = new boolean[26];
        for (char ch : chars) {
            cnt[ch - 'a']--;
            if (visited[ch - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > ch && cnt[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicateLetters("bcabc"));
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));
    }
}
