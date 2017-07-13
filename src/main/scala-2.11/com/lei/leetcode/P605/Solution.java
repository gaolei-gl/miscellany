package com.lei.leetcode.P605;

/**
 * Created by Lei on 2017/7/13.
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            int next = i == length - 1 ? 0 : flowerbed[i + 1];
            int prev = i == 0 ? 0 : flowerbed[i - 1];
            if (next == 0 && prev == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n -= 1;
            }
        }
        if (n <= 0) return true;
        else return false;
    }

    public static void main(String[] args) {

    }
}
