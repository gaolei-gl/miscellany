package com.lei.leetcode.P217;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lei on 2017/7/21.
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums)
            if (!set.add(i))
                return true;
        return false;
    }
}
