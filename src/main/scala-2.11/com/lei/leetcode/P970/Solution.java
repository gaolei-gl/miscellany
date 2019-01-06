package com.lei.leetcode.P970;

import com.lei.leetcode.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        if (x == 1 && y == 1) {
            if (bound >= 1) ans.add(1);
        } else if (x == 1) {
            int j = 0;
            while (Math.pow(y, j) + 1 <= bound) {
                ans.add((int) Math.pow(y, j) + 1);
                j++;
            }
        } else if (y == 1) {
            int j = 0;
            while (Math.pow(y, j) + 1 <= bound) {
                ans.add((int) Math.pow(y, j) + 1);
                j++;
            }

        } else {
            for (int i = 0; Math.pow(x, i) <= bound; i++) {
                int xx = (int) Math.pow(x, i);
                for (int j = 0; xx + Math.pow(y, j) <= bound; j++) {
                    ans.add(xx + (int) Math.pow(y, j));
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.powerfulIntegers(1, 2, 100));
    }
}
