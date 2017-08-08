package com.lei.leetcode.P119;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei on 2017/8/8.
 */
public class Solution {
    /*
    copy from discuss, brilliant thought, well done.
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        getRow(3);
    }
}
