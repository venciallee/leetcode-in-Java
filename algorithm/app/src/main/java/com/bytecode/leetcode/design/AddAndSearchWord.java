package com.bytecode.leetcode.design;

/**
 * 211. Add and Search Word - Data structure design
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * <p>
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * <p>
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * <p>
 * <a href="https://leetcode.com/problems/add-and-search-word-data-structure-design/">211. Add and Search Word - Data structure design</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/">211. 添加与搜索单词 - 数据结构设计</a>
 * <p>
 * Created by vencial on 2019-08-21.
 */
public class AddAndSearchWord {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] charArray, int k, TrieNode node) {
        if (k == charArray.length) return !node.item.equals("");
        if (charArray[k] != '.') {
            return node.children[charArray[k] - 'a'] != null && search(charArray, k + 1, node.children[charArray[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (search(charArray, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String item = "";
    }
}
