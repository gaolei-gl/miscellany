package com.lei.leetcode.P621;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lei on 2017/8/16.
 */
public class Solution {
    public static int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
        }


        return 0;
    }

    public static void main(String[] args) {
        char[] t = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(t, 2));
    }
}
