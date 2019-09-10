package com.bytecode.leetcode.tree;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * <p>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * <p>
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">230. Kth Smallest Element in a BST</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/">230. 二叉搜索树中第K小的元素</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class KthSmallestElementinaBST {

    /**
     * 1. 按照中序遍历把结点入栈
     * 2. 出栈时k--, 当k等于0, 出栈的结点即是目标结点
     * <p>
     * 1. according to inorder, and push all node to stack
     * 2. k decrease when pop from stack, and if k equal 0, then current node is what we need
     *
     * @param root root
     * @param k k
     * @return int
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int num = 0;
        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                num = node.val;
                break;
            }


            if (node.right != null) {
                root = node.right;
            }
        }
        return num;
    }
}
