package com.lei.leetcode.P990;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] ufConnect = new int[26];
        int[] ufNotConnect = new int[26];
        for (int i = 0; i < ufConnect.length; i++) {
            ufConnect[i] = i;
            ufNotConnect[i] = i;
        }
        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            if (s.contains("==")) {
                if (s.charAt(0) == s.charAt(3)) continue;
                union(ufConnect, s.charAt(0), s.charAt(3));
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            if (s.contains("!=")) {
                if (s.charAt(0) == s.charAt(3)) return false;
                if (connected(ufConnect, s.charAt(0), s.charAt(3))) return false;
            }
        }
        return true;
    }

    private void union(int[] uf, char x, char y) {
        int xi = find(uf, x);
        int yi = find(uf, y);
        if (xi > yi) uf[xi] = yi;
        else uf[yi] = xi;
    }

    private boolean connected(int[] uf, char x, char y) {
        return find(uf, x) == find(uf, y);
    }

    private int find(int[] uf, char x) {
        int i = x - 'a';
        List<Integer> tmp = new ArrayList<>();
        while (uf[i] != i) {
            tmp.add(i);
            i = uf[i];
        }
        for (int idx : tmp) uf[idx] = i;
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(s.equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(s.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(s.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(s.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }
}
