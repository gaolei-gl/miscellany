package com.lei.leetcode.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPQ<T extends Comparable<T>> {
    public MaxPQ(int size) {
        this.list = (T[]) new Comparable[size + 1];
        N = size;
    }

    private T[] list = null;
    private int N = 0;

    private void exch(int a, int b) {
        T t = list[a];
        list[a] = list[b];
        list[b] = t;
    }

    private boolean less(int a, int b) {
        return list[a].compareTo(list[b]) < 0;
    }

    private void sink(int idx) {
        while (idx * 2 <= N) {
            int j = idx * 2;
            if (j + 1 <= N && less(j, j + 1)) {
                j += 1;
            }
            if (!less(idx, j)) {
                break;
            }
            exch(idx, j);
            idx = j;
        }
    }

    private void swim(int idx) {
        while (idx > 1 && less(idx / 2, idx)) {
            exch(idx / 2, idx);
            idx /= 2;
        }
    }

    public void insert(T t) {
        N += 1;
        list[N] = t;
        swim(N);
    }

    public T delMax() {
        if (isEmpty()) {
            return null;
        }
        T t = list[1];
        exch(1, N);
        list[N] = null;
        N -= 1;
        sink(1);
        return t;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}

