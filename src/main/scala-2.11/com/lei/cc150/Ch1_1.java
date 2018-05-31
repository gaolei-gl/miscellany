package com.lei.cc150;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class Ch1_1 {
    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((checker & (1 << val)) == 1) {
                return false;
            } else {
                checker |= (1 << val);
            }
        }
        return true;
    }
}
