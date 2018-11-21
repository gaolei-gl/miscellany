package com.lei.leetcode.P322;

// this is for another coin change in CC189
public class CCSolution {
    private int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1;
        int ways = 0;
        for (int i = 0; amount >= i * denoms[index]; i++) {
            int remain = amount - i * denoms[index];
            ways += makeChange(remain, denoms, index + 1);
        }
        return ways;
    }

    public int makeChange(int amount, int[] denoms) {
        return makeChange(amount, denoms, 0);
    }

    public static void main(String[] args) {
        CCSolution s = new CCSolution();
        System.out.println(s.makeChange(100, new int[]{25, 10, 5, 1}));
    }
}
