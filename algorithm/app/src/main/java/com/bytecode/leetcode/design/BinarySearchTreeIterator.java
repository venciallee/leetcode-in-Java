package com.bytecode.leetcode.design;

import com.bytecode.leetcode.binarytree.TreeNode;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * <p>
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Example:
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * <p>
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/">173. Binary Search Tree Iterator</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/binary-search-tree-iterator/">173. 二叉搜索树迭代器</a>
 * <p>
 * Created by vencial on 2019-08-20.
 */
public class BinarySearchTreeIterator {

    private Stack<TreeNode> mStack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    /**
     * 1. 使用栈存储根结点以及所有左子结点, 调用next时Node出栈
     * 2. 把出栈的node的右子结点, 以及右子结点的所有左子结点入栈
     * 3. 返回val.
     * <p>
     * 1. push root and all sub left node, then node will pop when next() was called
     * 2. push the sub right node to stack, and push all sub left node.
     * 3. return val.
     *
     * @return the next smallest number
     */
    public int next() {
        if (hasNext()) {
            TreeNode node = mStack.pop();
            pushAll(node.right);
            return node.val;
        }
        return -1;
    }

    /**
     * whether stack is empty.
     *
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !mStack.isEmpty();
    }

    /**
     * push node and all sub left node to stack.
     *
     * @param node node
     */
    private void pushAll(TreeNode node) {
        for (; node != null; node = node.left) {
            mStack.push(node);
        }
    }

}
