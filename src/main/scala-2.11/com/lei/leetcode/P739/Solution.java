package com.lei.leetcode.P739;

import com.lei.leetcode.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private static class MinStack<T extends Comparable<T>> {

        /**
         * initialize your data structure here.
         */

        private List<T> values;
        private List<T> mins;
        private T min = null;

        public boolean isEmpty() {
            return values.isEmpty();
        }

        public MinStack(int capacity) {
            values = new ArrayList<>(capacity);
            mins = new ArrayList<>(capacity);
        }

        public void push(T x) {
            values.add(x);
            if (min == null || min.compareTo(x) > 0) {
                min = x;
                mins.add(x);
            } else {
                mins.add(min);
            }
        }

        public T pop() {
            T res = values.remove(values.size() - 1);
            if (values.isEmpty()) min = null;
            else {
                mins.remove(mins.size() - 1);
                min = mins.get(mins.size() - 1);
            }
            return res;
        }

        public T top() {
            return values.get(values.size() - 1);
        }

        public T getMin() {
            return mins.get(mins.size() - 1);
        }

    }

    private class Tuple implements Comparable<Tuple> {
        int idx;
        int value;

        public Tuple(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        MinStack<Tuple> stack = new MinStack<>(T.length);
        Stack<Tuple> tmp = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty() || stack.getMin().value > T[i]) {
                stack.push(new Tuple(i, T[i]));
                continue;
            }
            while (!stack.isEmpty() && stack.getMin().value < T[i]) {
                Tuple top = stack.pop();
                if (top.value < T[i])
                    ans[top.idx] = i - top.idx;
                else
                    tmp.push(top);
            }
            while (!tmp.isEmpty()) stack.push(tmp.pop());
            stack.push(new Tuple(i, T[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Utils.displayList(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
