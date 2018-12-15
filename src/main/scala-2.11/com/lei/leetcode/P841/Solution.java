package com.lei.leetcode.P841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    Queue<Integer> q;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] unLock = new boolean[rooms.size()];
        q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int room = q.poll();
            if (unLock[room]) continue;
            unLock[room] = true;
            q.addAll(rooms.get(room));
        }
        for (boolean b : unLock) if (!b) return b;
        return true;
    }
}
