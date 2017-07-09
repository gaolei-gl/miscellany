package com.lei.leetcode.P138;

import com.lei.leetcode.RandomListNode;

import java.util.HashMap;

/**
 * Created by lei on 17-7-9.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }

        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);

    }

    public static void main(String[] args) {

    }
}
