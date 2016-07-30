package com.lei.algorithm.link.chapter1;

import java.util.Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by com.lei on 16-1-20.
 */
public class RandomBag<Item> implements RandomBagInterface<Item> {
    int initSize = 10;
    int capacity = initSize;
    int index = 0;
    Object[] items;

    public RandomBag() {
        items = new Object[10];
    }

    public void resize() throws Exception {
        if (capacity * 2 < Integer.MAX_VALUE) {
            capacity *= 2;
        } else {
            throw new Exception("out of memory when expending bag");
        }
        Object[] newItems = new Object[capacity];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public Iterator<Item> iterator() {
        return new RandomBagIterator(this);
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return index;
    }

    public void add(Item item) throws Exception {
        if (index < capacity) {
            items[index++] = item;
        } else {
            resize();
            items[index++] = item;
        }
    }

    protected class RandomBagIterator implements Iterator<Item> {
        int cur;
        int size;
        RandomBag<Item> bag;
        List<Integer> indexs;

        public RandomBagIterator(RandomBag<Item> bag) {
            this.bag = bag;
            size = bag.size();
            cur = 0;
            indexs = new ArrayList<Integer>(size);
            for (int i = 0; i < size; i++) {
                indexs.add(i);
            }
            Collections.shuffle(indexs);
        }

        public boolean hasNext() {
            return cur != size;
        }

        public Item next() {
            return (Item) items[indexs.get(cur++)];
        }

        public void remove() {

        }
    }

}
