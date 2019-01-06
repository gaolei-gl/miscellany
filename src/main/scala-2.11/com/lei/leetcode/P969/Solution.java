package com.lei.leetcode.P969;

import com.lei.leetcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        // if array A is already sorted.
        if (isSorted(A, 0, A.length)) return ans;
        int cur = A.length;
        for (int k = A.length - 1; k >= 0; k--) {
            int j = k;
            while (j >= 0 && A[j] != cur) j--;
            if (j == k) {
                cur--;
                continue;
            }
            if (j != 0) {
                flip(A, j);
                ans.add(j + 1);
            }
            flip(A, k);
            ans.add(k + 1);
            cur--;
            if (isSorted(A, 0, k)) break;
        }
        return ans;
    }

    private void flip(int[] A, int end) {
        if (end == 0) return;
        for (int i = 0; i <= end / 2; i++) {
            int t = A[i];
            A[i] = A[end - i];
            A[end - i] = t;
        }
    }


    private boolean isSorted(int[] A, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            if (A[i] > A[i + 1]) return false;
        }
        return true;
    }

    private boolean isReverseOrdered(int[] A, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            if (A[i] < A[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
