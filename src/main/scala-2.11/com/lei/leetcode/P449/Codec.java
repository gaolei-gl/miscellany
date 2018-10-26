package com.lei.leetcode.P449;

import com.lei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "*";
        else {
            return root.val + serialize(root.left) + serialize(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> chs = new ArrayList<>(data.length());
        for (char c : data.toCharArray()) {
            if (c - '0' >= 0)
                chs.add(c - '0');
            else chs.add('*' - 0);
        }
        return deserialize(chs);
    }

    private TreeNode deserialize(List<Integer> data) {
        if (data.isEmpty()) return null;
        int c = data.remove(0);
        // means this is null
        if (c == '*') return null;
        TreeNode node = new TreeNode(c);
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        System.out.println(codec.serialize(tree));
        System.out.println(codec.serialize(codec.deserialize(codec.serialize(tree))));
    }
}

