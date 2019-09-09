package com.bytecode.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * <p>
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">103. Binary Tree Zigzag Level Order Traversal</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">103. 二叉树的锯齿形层次遍历</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * bfs by queue
     *
     * @param root root
     * @return List
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> treeList = new ArrayList<>();
        if (root == null) return treeList;
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> trees = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (count % 2 == 0) {
                    trees.add(0, queue.poll().val);
                } else {
                    trees.add(queue.poll().val);
                }
            }
            count++;
            treeList.add(trees);
        }
        return treeList;
    }
}
