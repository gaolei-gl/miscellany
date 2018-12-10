package com.lei.leetcode.P23;

import com.lei.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    });

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        for (int i = 0; i < len; i++) {
            if (lists[i] != null)
                queue.offer(lists[i]);
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = node;
            ListNode next = node.next;
            if (next != null) queue.offer(next);
        }

        cur.next = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.mergeKLists(new ListNode[3]{});
    }
}