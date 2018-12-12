package com.lei.leetcode.P60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map;

    public String getPermutation(int n, int k) {
        map = new HashMap<>();
        List<Integer> list = new ArrayList<>(n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
            int j = 0;
            while (fib(n - i - 1) < k) {
                k -= fib(n - i - 1);
                j++;
            }
            ans[i] = j;
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i : ans) {
            sb.append(list.remove(i));
        }
        return sb.toString();
    }

    private int fib(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n <= 1) {
            map.put(n, 1);
            return 1;
        } else {
            int res = fib(n - 1) * n;
            map.put(n, res);
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
