package com.lei.leetcode.P460;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private class Node {
        int key, value;
        Node prev, next;
        int frequency;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }

        public Node() {
            key = 0;
            value = 0;
        }
    }

    private class Entry {
        Node head, tail;

        public Entry() {
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public void remove(Node node) {
            if (node.prev == null || node.next == null) return;
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

        public Node removeLast() {
            if (isEmpty()) return null;
            Node node = tail.prev;
            node.prev.next = tail;
            tail.prev = node.prev;
            return node;
        }
    }

    private Map<Integer, Node> map;
    private Map<Integer, Entry> counter;
    private int capacity, size, min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        counter = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        updateFrequency(node);
        return node.value;
    }


    private void updateFrequency(Node node) {
        Entry entry = counter.computeIfAbsent(node.frequency, x -> new Entry());
        entry.remove(node);
        if (node.frequency == min && entry.isEmpty()) min++;
        node.frequency++;
        entry = counter.computeIfAbsent(node.frequency, x -> new Entry());
        entry.add(node);
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (size == capacity) {
                Entry entry = counter.get(min);
                if (entry == null) return;
                node = entry.removeLast();
                if (node != null) map.remove(node.key);
                node = new Node(key, value);
                min = 1;
                entry = counter.computeIfAbsent(min, x -> new Entry());
                entry.add(node);
                map.put(key, node);
            } else {
                size++;
                min = 1;
                node = new Node(key, value);
                Entry entry = counter.computeIfAbsent(min, x -> new Entry());
                entry.add(node);
                map.put(key, node);
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        cache.put(1, 1);
        cache.get(1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        cache.get(2);
//        cache.get(3);
//        cache.put(4, 4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);

    }
}