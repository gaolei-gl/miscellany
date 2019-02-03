package com.lei.leetcode.P987;

import com.lei.leetcode.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        helper(map, root);
        List<List<Integer>> ans = new LinkedList<>();
        for (List<Integer> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }

    private void helper(Map<Integer, List<Integer>> map, TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qSeq = new LinkedList<>();
        q.offer(root);
        qSeq.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, List<Integer>> tmp = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int idx = qSeq.poll();
                tmp.computeIfAbsent(idx, x -> new ArrayList<>()).add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                    qSeq.offer(idx - 1);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    qSeq.offer(idx + 1);
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : tmp.entrySet()) {
                List<Integer> t = entry.getValue();
                t.sort(Comparator.naturalOrder());
                if (map.containsKey(entry.getKey())) map.get(entry.getKey()).addAll(t);
                else map.put(entry.getKey(), t);
            }
        }
    }
}
