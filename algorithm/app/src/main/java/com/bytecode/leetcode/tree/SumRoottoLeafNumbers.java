package com.bytecode.leetcode.tree;

import java.util.Stack;

/**
 * 129. Sum Root to Leaf Numbers
 * <p>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * <p>
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">129. Sum Root to Leaf Numbers</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">129. 求根到叶子节点数字之和</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class SumRoottoLeafNumbers {

    /**
     * 1. 结点入栈, 并把子结点的值与当前结点值*10想加, 再更到子结点中
     * 2. 遇到叶子结点, 则计算sum值
     * <p>
     * 1. push node to stack and update sub tree's value by adding parent's value * 10
     * 2. if it's a leaf node, then count the sum
     *
     * @param root root
     * @return int
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                node.left.val += node.val * 10;
                stack.push(node.left);
            }

            if (node.right != null) {
                node.right.val += node.val * 10;
                stack.push(node.right);
            }

            if (node.left == null && node.right == null) {
                sum += node.val;
            }
        }

        return sum;
    }
}
