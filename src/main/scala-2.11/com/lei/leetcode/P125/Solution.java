package com.lei.leetcode.P125;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan 1 2, a canal: Panama"));
        System.out.println(s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome("0P"));
    }
}
