package com.lei.leetcode.P155;

class MinStack {

    /**
     * initialize your data structure here.
     */

    private int[] values;
    private int[] mins;
    private int top;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        values = new int[10240];
        mins = new int[10240];
        top = -1;
    }

    public void push(int x) {
        top++;
        values[top] = x;
        if (min > x) {
            min = x;
            mins[top] = x;
        } else {
            mins[top] = min;
        }
    }

    public void pop() {
        top--;
        if (top == -1) min = Integer.MAX_VALUE;
        else min = mins[top];
    }

    public int top() {
        return values[top];
    }

    public int getMin() {
        return mins[top];
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(3);
        obj.push(-1);
        obj.push(2);
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */