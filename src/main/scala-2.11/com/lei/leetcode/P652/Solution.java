package com.lei.leetcode.P652;

import com.lei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<String, Integer> map;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        ans = new ArrayList<>();
        traverse(root);
        return ans;
    }

    private String traverse(TreeNode root) {
        if (root == null) return " ";
        String val = root.val + "," + traverse(root.left) + "," + traverse(root.right);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (map.get(val) == 2) ans.add(root);
        return val;
    }

}
