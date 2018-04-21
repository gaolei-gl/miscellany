package com.lei.leetcode.heap;

public class IndexMinPQ<T extends Comparable<T>> {
    private int N;
    T[] keys = null;
    int[] pq;
    int[] qp;

    public IndexMinPQ(int size) {
        N = size;
        keys = (T[]) new Comparable[size + 1];
        pq = new int[size + 1];
        qp = new int[size + 1];
    }

    private boolean less(int a, int b) {
        return keys[a].compareTo(keys[b]) < 0;
    }

    private void exch(int a, int b) {
        T t = keys[a];
        keys[a] = keys[b];
        keys[b] = t;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            while (j + 1 <= N && less(j + 1, j)) {
                j += 1;
            }
            if (!less(j, k)) {
                break;
            }
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    public void insert(int k, T t) {
        keys[++N] = t;
        qp[k] = N;
        pq[N] = k;
        swim(N);
    }

    public void change(int k, T t) {

    }

    public boolean contains(int k) {

    }

    public int minIndex() {

    }

    public int delMin() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
