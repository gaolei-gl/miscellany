package com.lei.leetcode.P131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(s, 0, res, new ArrayList<>());
        return res;
    }

    private void backtracking(String s, int start, List<List<String>> res, List<String> prefix) {
        if (start == s.length()) res.add(new ArrayList<>(prefix));
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    prefix.add(s.substring(start, i + 1));
                    backtracking(s, i + 1, res, prefix);
                    prefix.remove(prefix.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (List<String> ls : s.partition("aaba")) {
            for (String str : ls) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

    }
}
