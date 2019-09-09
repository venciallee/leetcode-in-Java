package com.bytecode.leetcode.tree;

import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * <p>
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">114. Flatten Binary Tree to Linked List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/">114. 二叉树展开为链表</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class FlattenBinaryTreetoLinkedList {

    /**
     * 1. 把右子结点入栈, 再把左子结点入栈
     * 2. 出栈并设置left指针为null, right指针指向栈中上一个结点
     * <p>
     * 1. push left or right node to stack
     * 2. pop from stack and set left is null, and right is the last node from the stack
     *
     * @param root root
     */
    public void flatten(TreeNode root) {
        if (root == null) return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
