package com.lei.algorithm.link.chapter1;

import java.util.Iterator;

public class GDeque<Item> implements GDequeInterface<Item> {

    GDequeNode<Item> head;
    GDequeNode<Item> tail;
    private int length;

    protected class GDequeNode<Item> {
        GDequeNode<Item> previous;
        GDequeNode<Item> next;
        Item item;

        GDequeNode() {
            previous = null;
            next = null;
            item = null;
        }

        public GDequeNode(Item item) {
            this.item = item;
            previous = null;
            next = null;
        }
    }

    public GDeque() {
        head = null;
        tail = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public void pushLeft(Item item) {
        length++;
        GDequeNode<Item> node = new GDequeNode<Item>(item);
        // 没有任何节点
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    public void pushRight(Item item) {
        length++;
        GDequeNode<Item> node = new GDequeNode<Item>(item);
        // 没有任何节点
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public Item popLeft() {
        if (head == null) {
            throw new RuntimeException("The Deque is empty.");
        } else {
            length--;
            Item item = head.item;
            if (head.next != null) {
                head = head.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
            return item;
        }
    }

    public Item popRight() {
        if (tail == null) {
            throw new RuntimeException("The Deque is empty.");
        } else {
            length--;
            Item item = tail.item;
            if (tail.previous != null) {
                tail = tail.previous;
                tail.next = null;
            } else {
                head = null;
                tail = null;
            }
            return item;
        }
    }

    public Iterator<Item> iterator() {
        return new DequeIterator(this);
    }

    private class DequeIterator implements Iterator<Item> {
        GDeque<Item> deque;
        GDequeNode<Item> cur;

        public DequeIterator(GDeque<Item> deque) {
            this.deque = deque;
            this.cur = this.deque.head;
        }

        public boolean hasNext() {
            return cur != null;
        }

        public Item next() {
            Item item = cur.item;
            cur = cur.next;
            return item;
        }

        public void remove() {

        }
    }
}
