package com.lei.leetcode.P384;

import java.util.Arrays;
import java.util.Random;

class Solution {
    int[] original;
    Random random = new Random();

    public Solution(int[] nums) {
        original = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] ns = Arrays.copyOf(original, original.length);
        for (int i = 1; i < original.length; i++) {
            int idx = random.nextInt(i + 1);
            swap(ns, i, idx);
        }
        return ns;
    }

    private void swap(int[] ns, int a, int b) {
        int t = ns[a];
        ns[a] = ns[b];
        ns[b] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
