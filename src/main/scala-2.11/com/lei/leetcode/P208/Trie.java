package com.lei.leetcode.P208;

import java.util.Arrays;

class Trie {
    Node root;

    private class Node {
        public char val;
        boolean valid;
        Node[] successors;

        Node() {
            successors = new Node[26];
        }

        Node(char val) {
            this.val = val;
            successors = new Node[26];
        }

        void setValid() {
            this.valid = true;
        }

        public void add(char[] chars) {
            if (chars.length == 0) {
                this.setValid();
                return;
            }
            int idx = chars[0] - 'a';
            if (successors[idx] == null) {
                successors[idx] = new Node(chars[0]);
            }
            successors[idx].add(Arrays.copyOfRange(chars, 1, chars.length));
        }

        boolean search(char[] chars) {
            if (chars.length == 0) return this.valid;
            int idx = chars[0] - 'a';
            return successors[idx] != null && successors[idx].search(Arrays.copyOfRange(chars, 1, chars.length));
        }

        boolean startsWith(char[] chars) {
            if (chars.length == 0) {
                if (this.valid) return true;
                for (Node n : this.successors) {
                    if (n != null) return true;
                }
                return false;
            }

            int idx = chars[0] - 'a';
            return successors[idx] != null && successors[idx].startsWith(Arrays.copyOfRange(chars, 1, chars.length));
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) return;
        root.add(word.toCharArray());
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) return false;
        return root.search(word.toCharArray());
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        return root.startsWith(prefix.toCharArray());
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */