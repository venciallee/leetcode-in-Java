package com.bytecode.leetcode.tree;

/**
 * 110. Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * <p>
 * <a href="https://leetcode.com/problems/balanced-binary-tree/">110. Balanced Binary Tree</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class BalancedBinaryTree {
    /**
     * 1. 计算左右子树高度, 判断是否是高度平衡二叉树
     * 2. 根据第一步递归判断左右子树是否是高度平衡二叉树
     * <p>
     * 1. count the depth of the left or right subtree and return true if leftDepth and rightDepth is not differ by more than 1
     * 2. follow step1 by passing left and right tree node
     *
     * @param root root
     * @return boolean
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        boolean isBalanced = false;
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            isBalanced = true;
        }

        return isBalanced && isBalanced(root.left) && isBalanced(root.right);

    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
