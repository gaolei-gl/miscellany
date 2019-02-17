package com.lei.leetcode.P989;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> l = new ArrayList<>();
        if (K == 0) l.add(0);
        else {
            while (K > 0) {
                l.add(K % 10);
                K /= 10;
            }
            List<Integer> ll = new ArrayList<>(l.size());
            for (int i = l.size() - 1; i >= 0; i--) ll.add(l.get(i));
            l = ll;
        }
        int carry = 0;
        int i = A.length - 1;
        int j = l.size() - 1;
        while (i >= 0 && j >= 0) {
            carry += A[i] + l.get(j);
            l.set(j, carry % 10);
            carry /= 10;
            i--;
            j--;
        }
        while (i >= 0) {
            carry += A[i];
            l.add(0, carry % 10);
            carry /= 10;
            i--;
        }
        while (j >= 0) {
            carry += l.get(j);
            l.set(j, carry % 10);
            carry /= 10;
            j--;
        }
        if (carry != 0) l.add(0, 1);
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addToArrayForm(new int[]{0}, 23));
//        System.out.println(s.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
//        System.out.println(s.addToArrayForm(new int[]{2, 7, 4}, 181));
//        System.out.println(s.addToArrayForm(new int[]{2, 1, 5}, 806));
//        System.out.println(s.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }
}
