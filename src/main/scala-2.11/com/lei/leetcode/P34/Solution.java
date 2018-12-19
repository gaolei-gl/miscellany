package com.lei.leetcode.P34;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = Solution.firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //NOTE: A[mid] == target 时不停止，继续向左探索
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }

    /*
        more concise, and easy to understand.
     */
    public int[] searchRange2(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if(idx < 0) return new int[]{-1,-1};
        int start = idx, end = idx;
        while(start>0 && nums[start] == nums[start-1]) start--;
        while(end<nums.length - 1 && nums[end] == nums[end+1]) end++;
        return new int[]{start,end};
    }
}
