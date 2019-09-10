package com.bytecode.leetcode.tree;

/**
 * Definition for a Node.
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
