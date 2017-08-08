package com.lei.leetcode.P118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei on 2017/8/7.
 */
public class Solution {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> newRow = null, last = null;
        for (int i = 0; i < numRows; i++) {
            newRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    newRow.add(1);
                } else {
                    newRow.add(last.get(j - 1) + last.get(j));
                }
            }
            last = newRow;
            lists.add(newRow);
        }
        return lists;
    }
}
