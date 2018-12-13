package com.lei.leetcode.P430;

/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
 which may or may not point to a separate doubly linked list.
 These child lists may have one or more children of their own, and so on,
 to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 You are given the head of the first level of the list.
*/
class Solution {

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        @Override
        public String toString() {
            return "Node: " + val;
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node originHead = head;
        while (head != null) {
            if (head.child != null) {
                Node next = head.next;
                Node child = head.child;
                head.next = child;
                head.child = null;

                while (child.next != null) {
                    child = child.next;
                }
                child.next = next;
                if (next != null) next.prev = child;
                head.next.prev = head;
            }
            head = head.next;
        }
        return originHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        Node five = new Node();
        Node six = new Node();
        Node seven = new Node();
        one.prev = null;
        one.next = two;
        one.val = 1;

        two.prev = one;
        two.next = three;
        two.val = 2;

        two.child = six;
        six.val = 6;
        six.next = seven;

        seven.prev = six;
        seven.val = 7;


        three.prev = two;
        three.next = four;
        three.val = 3;

        three.child = five;
        five.val = 5;


        s.flatten(one);
        System.out.println();
    }

}
