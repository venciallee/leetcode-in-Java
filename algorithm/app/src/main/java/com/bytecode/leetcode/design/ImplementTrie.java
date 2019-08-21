package com.bytecode.leetcode.design;

/**
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * <p>
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">208. Implement Trie (Prefix Tree)</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">208. 实现 Trie (前缀树)</a>
 * <p>
 * Created by vencial on 2019-08-21.
 */
public class ImplementTrie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            if (trieNode.children[c - 'a'] == null) trieNode.children[c - 'a'] = new TrieNode();
            trieNode = trieNode.children[c - 'a'];
        }
        trieNode.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            if (trieNode.children[c - 'a'] == null) return false;
            trieNode = trieNode.children[c - 'a'];
        }
        return trieNode.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (char c : prefix.toCharArray()) {
            if (trieNode.children[c - 'a'] == null) return false;
            trieNode = trieNode.children[c - 'a'];
        }
        return true;
    }

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }
}
