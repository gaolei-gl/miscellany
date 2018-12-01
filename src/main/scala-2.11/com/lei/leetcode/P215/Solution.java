package com.lei.leetcode.P215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int n = map.getOrDefault(num, 0);
            if (n == 0) q.offer(num);
            map.put(num, n + 1);
        }
        int n = 0;
        while (k > 0) {
            n = q.poll();
            k -= map.get(n);
        }
        return n;
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest3(int[] nums, int k) {
        int idx = quickSelection(nums, 0, nums.length - 1, nums.length - k);
        return nums[idx];
    }

    private int quickSelection(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (i < end && less(nums[++i], pivot)) ;
            while (j > start && less(pivot, nums[--j])) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        if (j == k) return j;
        if (j > k) return quickSelection(nums, start, j - 1, k);
        else return quickSelection(nums, j + 1, end, k);
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    private boolean less(int a, int b) {
        return a < b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(s.findKthLargest3(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
