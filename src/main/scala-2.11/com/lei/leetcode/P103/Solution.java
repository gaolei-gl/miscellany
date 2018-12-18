package com.lei.leetcode.P103;

import com.lei.leetcode.ListNode;
import com.lei.leetcode.TreeNode;

import java.util.*;

public class Solution {
    Queue<TreeNode> q;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        q.offer(root);
        boolean reverseLevel = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            if (reverseLevel) Collections.reverse(tmp);
            reverseLevel = !reverseLevel;
            res.add(tmp);
        }
        return res;
    }
}
