package com.lei.leetcode.P605;

/**
 * Created by Lei on 2017/7/13.
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int index = 0;
        int len = flowerbed.length;

        while (index < len && n != 0) {
            if (flowerbed[index] == 0 && index == 0 && flowerbed[index + 1] == 0) {
                flowerbed[index] = 1;
                n -= 1;
            } else if (flowerbed[index] == 0 && flowerbed[index - 1] == 0 && index == len - 1) {
                flowerbed[index] = 1;
                n -= 1;gst
            } else if ([flowerbed[index] == 0 && flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0){
                flowerbed[index] = 1;
                n -= 1;
            }
            index += 1;
        }

        if (n == 0) return true;

        else return false;
    }
}
