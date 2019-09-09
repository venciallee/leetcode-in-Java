package com.bytecode.leetcode.tree;

/**
 * 101. Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 * <a href="https://leetcode.com/problems/symmetric-tree/">Symmetric Tree</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/symmetric-tree/">101. 对称二叉树</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class SymmetricTree {

    /**
     * recursive
     *
     * @param root root
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
