package com.lei.snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class ArrayToRange {
    public List<int[]> toRange(int[] arr) {
        List<int[]> ans = new ArrayList<>();
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                if (end == arr.length - 1) ans.add(Arrays.copyOfRange(arr, start, end + 1));
                else if (arr[end + 1] != arr[end] + 1) {
                    ans.add(Arrays.copyOfRange(arr, start, end + 1));
                    start = end;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayToRange obj = new ArrayToRange();
//        List<int[]> l = obj.toRange(new int[]{1, 2, 3, 5, 7, 8, 10});
//        List<int[]> l = obj.toRange(new int[]{1, 1, 1, 1, 1, 1, 1});        // 7个1
        List<int[]> l = obj.toRange(new int[]{1});        // 7个1
        for (int[] ll : l) {
            for (int i : ll) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
