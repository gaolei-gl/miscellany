package com.lei.leetcode.P461;

public class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int mask = 1 << i;
            if ((x & mask) != (y & mask)) ans++;
        }
        return ans;
    }
}
