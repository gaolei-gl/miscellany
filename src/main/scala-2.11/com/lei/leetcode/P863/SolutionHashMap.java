package com.lei.leetcode.P863;

import com.lei.leetcode.TreeNode;
import com.lei.leetcode.Utils;

import java.util.*;

class SolutionHashMap {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildMap(map, root, null);
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        seen.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) res.add(queue.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode t : map.get(node)) {
                    if (seen.contains(t)) continue;
                    seen.add(t);
                    queue.offer(t);
                }
            }
            K--;
        }
        return res;
    }

    private void buildMap(Map<TreeNode, List<TreeNode>> map, TreeNode root, TreeNode pre) {
        if (root == null) return;
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<>());
            if (pre != null) {
                map.get(root).add(pre);
                map.get(pre).add(root);
            }
            buildMap(map, root.left, root);
            buildMap(map, root.right, root);
        }
    }


    public static void main(String[] args) {
        SolutionHashMap s = new SolutionHashMap();
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        root.left = five;
        root.right = one;
        five.left = six;
        five.right = two;
        one.left = zero;
        one.right = eight;
        two.left = seven;
        two.right = four;

        List<Integer> res = s.distanceK(root, five, 2);
        Utils.displayList(res);
    }
}
