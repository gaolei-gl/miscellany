package com.lei.leetcode.P341;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> q;

    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        q.addAll(nestedList);
    }

    @Override
    public Integer next() {
        return q.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (q.isEmpty()) return false;
        if (q.peekFirst().isInteger()) return true;
        List<NestedInteger> l = q.pollFirst().getList();
        for (int i = l.size() - 1; i >= 0; i--) {
            q.addFirst(l.get(i));
        }
        return this.hasNext();
    }
}
