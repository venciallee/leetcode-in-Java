package com.bytecode.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * <p>
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">94. Binary Tree Inorder Traversal</a>
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">94. 二叉树的中序遍历</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class BinaryTreeInorderTraversal {

    /**
     * 1. 把左子结点均放入到栈中
     * 2. 结点出栈并放到List中
     * 3. 右子结点放到栈中
     * <p>
     * 1. push left node to stack
     * 2. pop
     * 3. push right node to stack
     *
     * @param root root
     * @return List
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inorderList = new ArrayList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            inorderList.add(curNode.val);
            curNode = curNode.right;
        }

        return inorderList;
    }
}
