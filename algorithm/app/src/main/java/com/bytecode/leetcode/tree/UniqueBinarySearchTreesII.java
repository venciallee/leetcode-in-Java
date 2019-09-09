package com.bytecode.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * <p>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * <p>
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * <p>
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">95. Unique Binary Search Trees II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/unique-binary-search-trees-ii/">95. 不同的二叉搜索树 II</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class UniqueBinarySearchTreesII {

    /**
     * 1. 递归生成所有左子树
     * 2. 递归生成所有右子树
     * 3. 遍历构造树
     * <p>
     * 1. recursive and create all left trees
     * 2. recursive and create all right trees
     * 3. construct tress by traversal
     *
     * @param n n
     * @return List
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    trees.add(node);
                }
            }
        }
        return trees;
    }
}
