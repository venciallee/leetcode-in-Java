package com.bytecode.leetcode.tree;

import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. Construct Binary Tree from Preorder and Inorder Traversal</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. 从前序与中序遍历序列构造二叉树</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    int rootIndex = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * 1. 用HashMap存储中序遍历结点的下标, 这样可以知道根结点左与右子结点的下标
     * 2. 递归构造树
     * <p>
     * 1. store inorder index to hashmap, so we can find the left or right part of the tree node
     * 2. construct tree node by recursive call
     *
     * @param preorder preorder
     * @param inorder inorder
     * @return TreeNode
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length, preorder, inorder);
    }

    private TreeNode helper(int start, int end, int[] preorder, int[] inorder) {
        if (start == end) return null;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int index = inorderMap.get(preorder[rootIndex]);
        rootIndex++;
        root.left = helper(start, index, preorder, inorder);
        root.right = helper(index + 1, end, preorder, inorder);
        return root;
    }
}
