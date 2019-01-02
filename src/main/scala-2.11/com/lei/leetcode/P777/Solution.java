package com.lei.leetcode.P777;

/*
    L只能向左转，R只能向右转。所以：
    1. start中的L的位置一定大于等于end中L位置
    2. start中的R的位置一定小于等于end中R的位置
 */
public class Solution {
    public boolean canTransform(String start, String end) {
        int ps = 0, pe = 0;
        int N = start.length();
        while (ps < N && pe < N) {
            while (ps < N && start.charAt(ps) == 'X') ps++;
            while (pe < N && end.charAt(pe) == 'X') pe++;
            if (ps == N && pe == N) return true;    // reach the end at the same time
            if (ps == N || pe == N) return false;    // one is reach the end and another is not
            if (start.charAt(ps) != end.charAt(pe)) return false;   // should be both 'L' or 'R'
            if (start.charAt(ps) == 'L' && ps < pe) return false;
            if (start.charAt(ps) == 'R' && ps > pe) return false;
            ps++;
            pe++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.canTransform("RXXLRXRXL", "XRLXXRRLX"));
//        System.out.println(s.canTransform("XXRXXLXXXX", "XXXXRXXLXX"));
        System.out.println(s.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }
}