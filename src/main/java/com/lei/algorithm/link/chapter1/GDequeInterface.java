package com.lei.algorithm.link.chapter1;

import java.util.Iterator;

/**
 * Created by Lei on 16/1/16.
 */
interface GDequeInterface<Item> extends Iterable<Item> {
    boolean isEmpty();

    int size();

    void pushLeft(Item item);

    void pushRight(Item item);

    Item popLeft();

    Item popRight();

}


