package com.bytecode.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * <p>
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">199. Binary Tree Right Side View</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">199. 二叉树的右视图</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class BinaryTreeRightSideView {

    /**
     * 1. 根据bfs, 先把每一层结点入队
     * 2. 每一层结点出列, 当结点A为每层第一个结点时, 放到list中即可
     * <p>
     * 1. offer node to queue by bfs
     * 2. when node is the first in every level, then put it to list.
     *
     * @param root root
     * @return List
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    list.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return list;
    }
}
