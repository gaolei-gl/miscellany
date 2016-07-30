package com.lei.algorithm.link.chapter1;

/**
 * Created by com.lei on 16-1-20.
 */
public class try_1_3_34 {
    public static void main(String[] args) throws Exception {
        RandomBagInterface<String> bag = new RandomBag<String>();
        System.out.println(bag.size());
        bag.add("bag1");
        bag.add("bag2");
        bag.add("bag3");
        bag.add("bag4");
        System.out.println(bag.size());
        for (String s : bag) {
            System.out.println(s);
        }
    }

}
