package com.lei.snippet;

public class SegmentTree {
    final private int[] segment;
    final private int[] data;

    public SegmentTree(int[] data) {
        this.data = data;
        segment = new int[getSize(data.length)];
        buildSegementTree(0, data.length - 1, 0);
    }

    private void buildSegementTree(int lo, int hi, int pos) {
        if (lo == hi) {
            segment[pos] = data[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        buildSegementTree(lo, mid, pos * 2 + 1);
        buildSegementTree(mid + 1, hi, pos * 2 + 2);
        segment[pos] = Math.min(segment[pos * 2 + 1], segment[pos * 2 + 2]);
    }

    public int rangeMinQuery(int qlo, int qhi, int lo, int hi, int pos) {
        // if there is a complete overlap, return the value
        if (qlo <= lo && qhi >= hi) return segment[pos];
        // if there is no overlap, return a MAX
        if (qlo > hi || qhi < lo) return Integer.MAX_VALUE;
        // if there a partial overlap, go both child
        int mid = lo + (hi - lo) / 2;
        int a1 = rangeMinQuery(qlo, qhi, lo, mid, pos * 2 + 1);
        int a2 = rangeMinQuery(qlo, qhi, mid + 1, hi, pos * 2 + 2);
        return Math.min(a1, a2);
    }


    // let's assume we always have more than a few numbers in array
    private int getSize(int size) {
        if (((size - 1) & size) == 0) return 2 * size - 1;
        int i = 2;
        while (size < i) i *= 2;
        return i - 1;
    }

    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{-1, 2, 4, 0});
        System.out.println(segmentTree.rangeMinQuery(1, 3, 0, 3, 0));
        System.out.println(segmentTree.rangeMinQuery(0, 3, 0, 3, 0));
        System.out.println(segmentTree.rangeMinQuery(1, 2, 0, 3, 0));
    }
}
