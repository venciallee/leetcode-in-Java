package com.bytecode.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 *  /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * <p>
 * <a href="https://leetcode.com/problems/path-sum-ii/submissions/">113. Path Sum II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/path-sum-ii/">113. 路径总和 II</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class PathSumII {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * recursive
     *
     * @param root root
     * @param sum sum
     * @return List
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(list));
        }
        helper(root.left, sum, list);
        helper(root.right, sum, list);
        list.remove(list.size() - 1);
    }
}
