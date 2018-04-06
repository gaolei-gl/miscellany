package com.lei.leetcode.heap;

import java.util.ArrayList;
import java.util.List;


public class Heap {
    private List<Integer> heap = new ArrayList();

    public void display() {
        for (int i : heap) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public Heap(int[] a) {
        for (int i : a) {
            heap.add(i);
        }
        initHeap();
    }

    private void swap(int a, int b) {
        int t = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, t);
    }

    public Integer parent(int i) {
        if (i < 1) {
            return null;
        }
        return (i - 1) / 2;
    }

    public Integer left(int i) {
        return 2 * i + 1 <= heap.size() - 1 ? 2 * i + 1 : null;
    }

    public Integer right(int i) {
        return 2 * i + 2 <= heap.size() - 1 ? 2 * i + 2 : null;
    }

    public void sink(int i) {
        if (i < 0) {
            return;
        }
        if (left(i) != null && right(i) == null) {
            if (heap.get(i) > heap.get(left(i))) {
                swap(i, left(i));
                sink(left(i));
                return;
            }
        }
        if (left(i) != null && right(i) != null) {
            int min = heap.get(left(i)) > heap.get(right(i)) ? right(i) : left(i);
            if (heap.get(min) < heap.get(i)) {
                swap(i, min);
                sink(min);
            }
        }
    }

    public void bubble(int i) {
        if (i < 0 || i > heap.size() - 1) {
            return;
        }
        Integer p = parent(i);
        if (p != null && heap.get(p) > heap.get(i)) {
            swap(p, i);
            bubble(p);
        }

    }

    public void initHeap() {
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            sink(i);
        }
    }

    public Integer removeTop() {
        if (heap.size() == 0) {
            return null;
        }
        int top = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (heap.size() != 0) {
            sink(0);
        }
        return top;
    }

    public Integer replaceTop(int x) {
        if (heap.size() == 0) {
            heap.add(x);
            return x;
        }
        int top = heap.get(0);
        heap.set(0, x);
        sink(0);
        return top;
    }

    public void add(int x) {
        heap.add(x);
        bubble(heap.size() - 1);
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{
                4, 76, 1, 7, 90, 3, 2, 4, 1, 2
        });
        heap.display();
        heap.add(-1);
        heap.display();
    }
}
