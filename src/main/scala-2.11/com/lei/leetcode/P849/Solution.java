package com.lei.leetcode.P849;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int k = 0, len = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                k = 0;
            } else {
                k++;
                len = Math.max(len, (k + 1) / 2);
            }
        }

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                len = Math.max(i, len);
                break;
            }
        }

        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                len = Math.max(len, seats.length - i - 1);
                break;
            }
        }
        return len;
    }

}
