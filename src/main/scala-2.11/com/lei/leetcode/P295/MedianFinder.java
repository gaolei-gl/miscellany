package com.lei.leetcode.P295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    /**
     * initialize your data structure here.
     */

    PriorityQueue<Integer> bigEndian;
    PriorityQueue<Integer> smallEdian;

    public MedianFinder() {
        bigEndian = new PriorityQueue<>(Comparator.reverseOrder()); //  the first half
        smallEdian = new PriorityQueue<>(); //  the second half
    }

    public void addNum(int num) {
        if (bigEndian.size() != 0) {
            if (bigEndian.peek() >= num) bigEndian.offer(num);
            else smallEdian.offer(num);
        } else {
            bigEndian.offer(num);
        }
        if (!bigEndian.isEmpty() && bigEndian.size() - smallEdian.size() > 1)
            smallEdian.offer(bigEndian.remove());
        else if (!smallEdian.isEmpty() && smallEdian.size() - bigEndian.size() > 1)
            bigEndian.offer(smallEdian.remove());
    }

    public double findMedian() {
        if ((bigEndian.size() + smallEdian.size()) % 2 == 0) {
            return (bigEndian.peek() + smallEdian.peek()) / 2.0;
        } else {
            return bigEndian.size() > smallEdian.size() ? (double) bigEndian.peek() : (double) smallEdian.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(12);
        mf.addNum(10);
        mf.addNum(13);
        mf.addNum(11);
        System.out.println(mf.findMedian());
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */