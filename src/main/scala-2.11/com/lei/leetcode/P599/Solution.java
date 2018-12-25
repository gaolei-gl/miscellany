package com.lei.leetcode.P599;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map1.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) map2.put(list2[i], i);
        int min = Integer.MAX_VALUE;
        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int sum = entry.getValue() + map2.get(entry.getKey());
                if (sum < min) {
                    result.clear();
                    result.add(entry.getKey());
                    min = sum;
                } else if (sum == min) {
                    result.add(entry.getKey());
                }
            }
        }
        String[] arr = new String[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
