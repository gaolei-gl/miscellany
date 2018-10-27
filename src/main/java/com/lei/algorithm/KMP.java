package com.lei.algorithm;

/*
    https://www.youtube.com/watch?v=KG44VoDtsAA
 */
public class KMP {
    public static void main(String[] args) {
        char[] pat = "acacabacacabacacac".toCharArray();
        int M = pat.length;
        int[] a = new int[M];
        a[0] = 0;

        for (int i = 1, j = 0; i < M; i++) {
            if (pat[i] == pat[j]) {
                j++;
                a[i] = j;
                continue;
            }
            while (j != 0 && pat[j] != pat[i])
                j = a[j - 1];

            if (j == 0) a[i] = 0;
            else {
                a[i] = j + 1;
                j++;
            }
        }

        for (int i = 0; i < M; i++)
            System.out.print(a[i]);
        System.out.println();
    }

}