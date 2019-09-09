package com.bytecode.leetcode.tree;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * <p>
 *     2
 *    / \
 *   1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">98. 验证二叉搜索树</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class ValidateBinarySearchTree {

    /**
     * 1. 判断当前结点是否满足BST
     * 2. 递归调用, 判断左子树和右字数是否满足BST
     * <p>
     * 1. if root is not a BST then return false
     * 2. pass left tree and right tree to repeat step 1 by recursive call
     *
     * @param root root
     * @return boolean
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer higher) {
        if(root == null) return true;
        if ((lower != null && root.val <= lower) || (higher != null && root.val >= higher )) return false;
        if (!isValidBST(root.left, lower, root.val)) return false;
        if (!isValidBST(root.right, root.val, higher)) return false;
        return true;
    }
}
