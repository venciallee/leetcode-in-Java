package com.bytecode.leetcode.tree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * <p>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * <p>
 * <a href=""></a>
 * <p>
 * <a href=""></a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class ConvertSortedArraytoBinarySearchTree {

    /**
     * pre-order recursive
     *
     * @param nums nums
     * @return TreeNode
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int start, int end, int[] nums) {
        if (start > end) return null;
        int rootIndex = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(start, rootIndex - 1, nums);
        root.right = helper(rootIndex + 1, end, nums);
        return root;
    }
}
