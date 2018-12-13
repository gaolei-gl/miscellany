package com.lei.leetcode.P752;

import java.util.*;

public class Solution {

    public static int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        int depth = 0;
        String marker = "*";
        q.addAll(Arrays.asList("0000", "*"));
        while (!q.isEmpty()) {
            String node = q.poll();
            if (node.equals(target))
                return depth;
            if (visited.contains(node) || deads.contains(node))
                continue;
            if (node.equals(marker) && q.isEmpty())
                return -1;
            if (node.equals(marker)) {
                q.add(marker);
                depth += 1;
            } else {
                visited.add(node);
                q.addAll(getSuccessors(node));
            }
        }
        return depth;
    }

    private static List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1) + str.substring(i + 1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1) + str.substring(i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(s.openLock(new String[]{"8888"}, "0009"));
        System.out.println(s.openLock(new String[]{"0000"}, "8888"));
        System.out.println(s.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }
}
