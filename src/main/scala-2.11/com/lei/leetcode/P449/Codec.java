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
            return String.valueOf(root.val) + ',' + serialize(root.left) + ',' + serialize(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> chs = new ArrayList<>();
        for (String s : data.split(",")) {
            chs.add(s);
        }
        return deserialize(chs);
    }

    private TreeNode deserialize(List<String> data) {
        if (data.isEmpty()) return null;
        String s = data.remove(0);
        // means this is null
        if (s.equals("*")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode tree = new TreeNode(2);
        tree.right = new TreeNode(1);
        tree.right.right = new TreeNode(3);
        System.out.println(codec.serialize(tree));
        System.out.println(codec.serialize(codec.deserialize(codec.serialize(tree))));
    }
}

