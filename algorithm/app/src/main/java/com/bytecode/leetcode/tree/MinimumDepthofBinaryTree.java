package com.bytecode.leetcode.tree;

/**
 * 111. Minimum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 * <p>
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">111. Minimum Depth of Binary Tree</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">111. 二叉树的最小深度</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class MinimumDepthofBinaryTree {
    /**
     * recursive
     *
     * @param root root
     * @return int
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int minDep = Integer.MAX_VALUE;
        if (root.left != null) {
            minDep = Math.min(minDepth(root.left), minDep);
        }
        if (root.right != null) {
            minDep = Math.min(minDepth(root.right), minDep);
        }
        return minDep + 1;
    }
}
