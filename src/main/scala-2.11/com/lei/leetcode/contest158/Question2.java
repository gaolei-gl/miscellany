package com.lei.leetcode.contest158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Question2 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] moves = new int[][]{{0, 1}, {1, 0}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}};
        Set<Integer> queeneSet = new HashSet<>();
        for (int[] q : queens) {
            queeneSet.add(q[0] * 9 + q[1]);
        }

        LinkedList<int[]> probQueen = new LinkedList<>();
        for (int[] move : moves) {
            probQueen.offer(new int[]{king[0], king[1], move[0], move[1]});
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!probQueen.isEmpty()) {
            int[] cur = probQueen.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int move_x = cur[2];
            int move_y = cur[3];
            if (x < 0 || x > 8 || y < 0 || y >= 8) {
                continue;
            }
            if (queeneSet.contains(x * 9 + y)) {
                res.add(new ArrayList<>(Arrays.asList(x, y)));
                continue;
            }
            probQueen.offerLast(new int[]{x + move_x, y + move_y, move_x, move_y});
        }

        return res;
    }
}
