package com.lei.leetcode.P93;

import com.lei.leetcode.Utils;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, new StringBuffer(), 0, 0);
        Utils.displayList(res);
        return res;
    }

    private void helper(String s, List<String> res, StringBuffer pre, int level, int idx) {
        int n = s.length();
        if (level >= 4 || idx >= n) {
            if (level == 4 && idx == n) {
                res.add(pre.toString());
                return;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (idx + i > n) break;
            int num = Integer.parseInt(s.substring(idx, idx + i));
            if (i == 1 || i == 2 && num >= 10 && num <= 99 || i == 3 && num >= 100 && num <= 255) {
                pre.append(num);
                if (level < 3) pre.append(".");
                helper(s, res, pre, level + 1, idx + i);
                if (level < 3) pre.deleteCharAt(pre.length() - 1);
                pre.delete(pre.length() - i, pre.length());
            }
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.restoreIpAddresses("25525511135");
    }
}
