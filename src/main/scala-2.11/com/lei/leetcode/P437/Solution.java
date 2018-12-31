package com.lei.leetcode.P437;

import com.lei.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // 如果后面直接减到了0 就表示从root到current node的整条链路和是target 所以这里必须要提前加入这对值
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int curSum, int target, Map<Integer, Integer> map) {
        if (root == null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += helper(root.left, curSum, target, map) + helper(root.right, curSum, target, map);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}
