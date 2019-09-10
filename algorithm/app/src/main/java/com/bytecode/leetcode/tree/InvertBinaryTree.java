package com.bytecode.leetcode.tree;

/**
 * 226. Invert Binary Tree
 * <p>
 * Invert a binary tree.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 * <a href="https://leetcode.com/problems/invert-binary-tree/">226. Invert Binary Tree</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/invert-binary-tree/">226. 翻转二叉树</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class InvertBinaryTree {
    /**
     * 1. recursive to the bottom.
     * 2. switch left and right pointer
     *
     * @param root root
     * @return TreeNode
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        return root;
    }
}
