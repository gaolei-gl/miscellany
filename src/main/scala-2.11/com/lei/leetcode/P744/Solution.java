package com.lei.leetcode.P744;

import java.util.Arrays;

/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 */
public class Solution {
    public static void main(String[] args) {
//        char[] chars = new char[]{'c', 'f', 'j', 'j', 'j', 'j', 'j', 'j', 'j', 'j', 'j', 'j'};
        char[] chars = new char[]{'c', 'c', 'f', 'f', 'j', 'j', 'j'};
        char c = 'j';
        System.out.println(nextGreatestLetter(chars, c));
//        System.out.println(bs(chars, 0, chars.length - 1, c));
//        System.out.println(Arrays.binarySearch(chars, c));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int idx = bs(letters, 0, letters.length, target);
        if (idx == letters.length) {
            return letters[0];
        } else {
            return letters[idx];
        }
    }

    public static int bs(char[] letters, int lo, int hi, char target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
