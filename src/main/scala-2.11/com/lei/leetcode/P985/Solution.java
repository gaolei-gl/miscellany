package com.lei.leetcode.P985;

import com.lei.leetcode.Utils;

public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            A[queries[i][1]] += queries[i][0];
            int ans = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] % 2 == 0) ans += A[j];
            }
            res[i] = ans;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = s.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{
                {1, 0},
                {-3, 1},
                {-4, 0},
                {2, 3}
        });
        Utils.displayList(r);

    }
}
