package com.lei.leetcode;

import java.util.List;

/**
 * Created by Lei on 2017/7/4.
 */
public class Utils {
    public static <T> void displayList(List<T> list) {
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void displayList(int[] list) {
        for (int t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
