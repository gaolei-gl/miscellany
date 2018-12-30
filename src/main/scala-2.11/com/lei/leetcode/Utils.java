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

    public static void displayList(String[] list) {
        for (String t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void displayList(int[][] list) {
        for (int[] ls : list) {
            displayList(ls);
        }
    }

    public static <T> void display2List(List<List<T>> list) {
        for (List<T> ts : list) {
            displayList(ts);
        }
    }
}
