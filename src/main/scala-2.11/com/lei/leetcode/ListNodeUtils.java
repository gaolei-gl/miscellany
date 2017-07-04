package com.lei.leetcode;

/**
 * Created by Lei on 2017/7/4.
 */
public class ListNodeUtils {

    public static ListNode reverse(ListNode l) {
        ListNode pre = null;
        while (l != null) {
            ListNode next = l.next;
            l.next = pre;
            pre = l;
            l = next;
        }
        return pre;
    }

    public static int length(ListNode l) {
        int i = 0;
        while (l != null) {
            i++;
            l = l.next;
        }
        return i;
    }

}
