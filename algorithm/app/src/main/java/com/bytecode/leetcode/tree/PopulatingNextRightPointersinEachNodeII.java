package com.bytecode.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * <p>
 * Given a binary tree
 * <p>
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Example:
 * <p>
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * <p>
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 * <p>
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">117. Populating Next Right Pointers in Each Node II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/">117. 填充每个节点的下一个右侧节点指针 II</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class PopulatingNextRightPointersinEachNodeII {

    /**
     * 1. 把结点放入到队列中
     * 2. 结点出队, 如果左结点且右结点不为空, 左结点的next指向右结点, 如果左结点不为空而右结点为空, 则往后找到不为空的左或右结点
     * 3. 如果右结点不为空, 则往后找到不为空的左或右结点
     * <p>
     * 1. push node to queue
     * 2. poll from the queue, if left & right sub node is not null, then left.next = right.next,
     * else left is not null but right is null, then found and pointer to the left or right sub node in the next sub tree which is not null.
     * 3. if right sub node is not null, then found and pointer to the left or right sub node in the next sub tree which is not null.
     *
     * @param root root
     * @return Node
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                if (node.right != null) {
                    node.left.next = node.right;
                } else {
                    Node next = node.next;
                    while (next != null) {
                        if (next.left != null || next.right != null) {
                            node.left.next = next.left != null ? next.left : next.right;
                            break;
                        } else {
                            next = next.next;
                        }
                    }
                }
            }
            if (node.right != null) {
                Node next = node.next;
                while (next != null) {
                    if (next.left != null || next.right != null) {
                        node.right.next = next.left != null ? next.left : next.right;
                        break;
                    } else {
                        next = next.next;
                    }
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }

}
