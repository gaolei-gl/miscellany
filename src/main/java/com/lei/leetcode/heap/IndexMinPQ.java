package com.lei.leetcode.heap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<T extends Comparable<T>> implements Iterable<T> {
    private int n;
    private int maxN;
    T[] keys;
    int[] pq;       // from heap view
    int[] qp;       // from array view

    public IndexMinPQ(int maxN) {
        this.maxN = maxN;
        this.n = 0;
        keys = (T[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i < maxN + 1; i++) {
            qp[i] = -1;
        }
    }


    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        if (i < 0 || i > maxN) throw new IllegalArgumentException();
        return qp[i] != -1;
    }

    public int size() {
        return n;
    }


    /**
     * Associates key with index {@code i}.
     *
     * @param i   an index
     * @param key the key to associate with index {@code i}
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if there already is an item associated
     *                                  with index {@code i}
     */
    public void insert(int i, T key) {
        if (i < 0 || i > maxN) throw new IllegalArgumentException();
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        keys[i] = key;
        n++;
        qp[i] = n;
        pq[n] = i;
        swim(n);
    }

    /**
     * Returns an index associated with a minimum key.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int minIndex() {
        if (n == 0) throw new NoSuchElementException("Priority queue is empty");
        return pq[1];
    }

    /**
     * Returns a minimum key.
     *
     * @return a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */

    public T minKey() {
        if (n == 0) throw new NoSuchElementException("Priority queue is empty");
        return keys[pq[1]];
    }

    /**
     * Removes a minimum key and returns its associated index.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int delMin() {
        int min = minIndex();
        exch(1, n);
        pq[n] = -1;
        n--;
        sink(1);

        qp[min] = -1;
        keys[min] = null;
        return min;
    }

    /**
     * Returns the key associated with index {@code i}.
     *
     * @param i the index of the key to return
     * @return the key associated with index {@code i}
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public T keyOf(int i) {
        if (i < 0 || i > maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in priority queue");
        return keys[i];
    }

    /**
     * Change the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to change
     * @param key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void changeKey(int i, T key) {
        if (i < 0 || i > maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }


    /**
     * Decrease the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to decrease
     * @param key decrease the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key >= keyOf(i)}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void decreaseKey(int i, T key) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
    }

    /**
     * Increase the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to increase
     * @param key increase the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key <= keyOf(i)}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void increaseKey(int i, T key) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(qp[i]);
    }


    /**
     * Remove the key associated with index {@code i}.
     *
     * @param i the index of the key to remove
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void delete(int i) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = null;
        exch(n, qp[i]);
        n--;
        sink(qp[i]);
        // do we really need this?
        swim(qp[i]);
        qp[i] = -1;
    }

    private boolean greater(int a, int b) {
        return keys[pq[a]].compareTo(keys[pq[b]]) > 0;
    }

    private void exch(int a, int b) {
        int swap = pq[a];
        pq[a] = pq[b];
        pq[b] = swap;

        qp[pq[a]] = a;
        qp[pq[b]] = b;
    }

    private void sink(int i) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (j + 1 <= n && greater(j, j + 1)) {
                j += 1;
            }
            if (!greater(i, j)) break;
            exch(i, j);
            i = j;
        }
    }

    private void swim(int i) {
        while (i > 1 && greater(i / 2, i)) {
            exch(i / 2, i);
            i /= 2;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<T> {
        private IndexMinPQ<T> copy;

        public HeapIterator() {
            this.copy = new IndexMinPQ<T>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }


        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T t = copy.minKey();
            copy.delMin();
            return t;
        }
    }

    public static void main(String[] args) {
        // insert a bunch of strings
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};

        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        // delete and print each key
        while (!pq.isEmpty()) {
            int i = pq.delMin();
            System.out.println(i + " " + strings[i]);
        }
        System.out.println();

        // reinsert the same strings
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        // print each key using the iterator
        for (String t : pq) {
            System.out.println(t);
        }
        while (!pq.isEmpty()) {
            pq.delMin();
        }

    }
}
