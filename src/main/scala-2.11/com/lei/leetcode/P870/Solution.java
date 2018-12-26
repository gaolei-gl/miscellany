package com.lei.leetcode.P870;

import java.util.*;

public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        List<Integer> AA = new ArrayList<Integer>() {{for (int i : A) add(i);}};
        Collections.sort(AA);
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int idx = Collections.binarySearch(AA, B[i] + 1);
            idx = idx < 0 ? -idx - 1: idx;
            if (idx < AA.size()) res[i] = AA.remove(idx);
            else res[i] = AA.remove(0);
        }
        return res;
    }
}

/*
[8,2,4,4,5,6,6,0,4,7]
[0,8,7,4,4,2,8,5,2,0]
this is a edge case, there are same value occur multiple times. and if we use binary search to find B[i] in AA, it
will produce equal values and not utilize the max "respect", so we find the current value +1 to make sure "bigger" not equal.

 */


