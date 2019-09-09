package com.bytecode.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * <p>
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">102. Binary Tree Level Order Traversal</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">102. 二叉树的层次遍历</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * bfs by queue
     *
     * @param root root
     * @return List
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> treeList = new ArrayList<>();
        if(root == null) return treeList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> trees = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                trees.add(queue.poll().val);
            }
            treeList.add(trees);
        }

        return treeList;
    }

}
