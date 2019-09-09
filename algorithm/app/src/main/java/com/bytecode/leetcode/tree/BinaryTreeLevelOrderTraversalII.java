package com.bytecode.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * <p>
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">107. Binary Tree Level Order Traversal II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">107. 二叉树的层次遍历 II</a>
 * Created by vencial on 2019-09-09.
 */
public class BinaryTreeLevelOrderTraversalII {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * recursive
     *
     * @param root root
     * @return List
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return ;
        }
        if (level == res.size()) {
            List<Integer> list = new ArrayList<>();
            res.add(0, list);
        }
        res.get(res.size() - level - 1).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
}
