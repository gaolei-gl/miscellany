package com.lei.leetcode.P71;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution2 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("", "..", "."));
        for (String p : path.split("/")) {
            if (!skip.contains(p)) stack.push(p);
            else if (p.equals("..") && !stack.isEmpty()) stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
