package com.bytecode.leetcode.tree;

/**
 * 112. Path Sum
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * <p>
 * <a href="https://leetcode.com/problems/path-sum/">112. Path Sum</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/path-sum/">112. 路径总和</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class PathSum {

    /**
     * recursive.
     *
     * @param root root
     * @param sum sum
     * @return boolean
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
