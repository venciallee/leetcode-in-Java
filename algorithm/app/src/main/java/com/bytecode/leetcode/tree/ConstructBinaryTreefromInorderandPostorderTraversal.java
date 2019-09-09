package com.bytecode.leetcode.tree;

import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. Construct Binary Tree from Inorder and Postorder Traversal</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. 从中序与后序遍历序列构造二叉树</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    int rootIndex = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * 1. 用HashMap存储中序遍历结点的下标, 这样可以知道根结点左与右子结点的下标
     * 2. 递归构造树
     * <p>
     * 1. store inorder index to hashmap, so we can find the left or right part of the tree node
     * 2. construct tree node by recursive call
     *
     * @param inorder inorder
     * @param postorder postorder
     * @return TreeNode
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, postorder.length, inorder, postorder);
    }

    private TreeNode helper(int start, int end, int[] inorder, int[] postorder) {
        if (start == end) return null;
        int rootVal = postorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        rootIndex--;
        int index = inorderMap.get(rootVal);
        root.right = helper(index + 1, end, inorder, postorder);
        root.left = helper(start, index, inorder, postorder);
        return root;
    }
}
