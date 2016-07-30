package com.lei.algorithm.link.chapter1;

/**
 * Created by com.lei on 16-1-20.
 */
public interface RandomBagInterface<Item> extends Iterable<Item> {
    boolean isEmpty();

    int size();

    void add(Item item) throws Exception;
}
