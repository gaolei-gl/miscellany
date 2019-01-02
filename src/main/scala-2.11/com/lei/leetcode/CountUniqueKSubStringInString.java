package com.lei.leetcode;

import java.util.Arrays;

// Count number of substrings with exactly k distinct characters
public class CountUniqueKSubStringInString {
    public int countkDist(String str, int k) {
        int length = str.length();
        if (k > length) return 0;
        int[] cnt = new int[26];
        int res = 0;
        for (int i = 0; i < length; i++) {
            Arrays.fill(cnt, 0);
            int distCnt = 0;
            for (int j = i; j < length; j++) {
                if (cnt[str.charAt(j) - 'a'] == 0)
                    distCnt++;
                cnt[str.charAt(j) - 'a']++;
                if (distCnt == k) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountUniqueKSubStringInString ob = new CountUniqueKSubStringInString();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k + " distinct characters : "
                + ob.countkDist(ch, k));
    }
}
