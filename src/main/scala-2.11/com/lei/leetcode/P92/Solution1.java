//package com.lei.leetcode.P92;
//
//import com.lei.leetcode.ListNode;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.LinkedList;
//
///**
// * Created by Lei on 2017/7/4.
// */
//public class Solution1 {
//    public static void main(String[] args) {
//
//    }
//
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        ListNode h = head;
//        int i = 1;
//        while (i < m) {
//            i++;
//            head = head.next;
//        }
//
//        LinkedList<ListNode> cache = new LinkedList<>();
//        while (m < n) {
//            m++;
//            cache.add(head);
//            head = head.next;
//        }
//
//    }
//}
