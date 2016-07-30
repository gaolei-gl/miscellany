package com.lei.algorithm.link.chapter1;

/**
 * Created by Lei on 16/1/16.
 */
public class try_1_3_33 {
    public static void main(String[] args) {
        GDeque<String> deque = new GDeque<String>();
        GDeque.GDequeNode head = deque.head;
        deque.pushLeft("first ");
        deque.pushRight("middle");
//        System.out.println(deque.size());
        deque.pushLeft("second ");
        System.out.println("Pop out: " + deque.popLeft());
        System.out.println("Pop out: " + deque.popLeft());
        System.out.println("Pop out: " + deque.popLeft());
//        System.out.println("Pop out: " + deque.popLeft());
        for (String s : deque) {
            System.out.println(s);
        }
        System.out.println("Current size is: " + deque.size());
    }

}
