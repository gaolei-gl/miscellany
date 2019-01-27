package com.lei.leetcode.P984;

public class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder(A + B);
        while (A + B > 0) {
            int l = sb.length();
            if (l > 1 && sb.charAt(l - 1) == sb.charAt(l - 2)) {
                if (sb.charAt(l - 1) == 'a') {
                    sb.append('b');
                    B--;
                } else {
                    sb.append('a');
                    A--;
                }
            } else {
                if (A > B) {
                    sb.append('a');
                    A--;
                } else {
                    sb.append('b');
                    B--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strWithout3a3b(5, 3));
    }

}
