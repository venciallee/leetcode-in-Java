package com.bytecode.leetcode.tree;

import java.util.Stack;

/**
 * 222. Count Complete Tree Nodes
 * <p>
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * <p>
 * Output: 6
 * <p>
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes/">222. Count Complete Tree Nodes</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class CountCompleteTreeNodes {

    /**
     * dfs by stack
     *
     * @param root root
     * @return int
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return count;
    }
}
