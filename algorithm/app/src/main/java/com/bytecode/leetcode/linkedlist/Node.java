package com.bytecode.leetcode.linkedlist;

/**
 * Definition for a Node.
 * <p>
 * Created by vencial on 2019-09-08.
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
