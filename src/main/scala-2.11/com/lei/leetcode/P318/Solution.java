package com.lei.leetcode.P318;

public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        if (words == null || words.length == 0) return max;
        int[] nums = new int[words.length];
        int[] length = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int n = 0;
            for (char c : words[i].toCharArray()) {
                n |= 1 << c - 'a';
            }
            length[i] = words[i].length();
            nums[i] = n;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    max = Math.max(length[i] * length[j], max);
                }
            }
        }
        return max;
    }
}
