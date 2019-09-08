package com.bytecode.leetcode.linkedlist;

import com.bytecode.leetcode.binarytree.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * <p>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">109. Convert Sorted List to Binary Search Tree</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/">109. 有序链表转换二叉搜索树</a>
 * <p>
 * Created by vencial on 2019-09-08.
 */
public class ConvertSortedListtoBST {

    private ListNode top;

    /**
     * 按照先序遍历, 递归构建平衡二叉树
     * <p>
     * base on the pre-order traversal
     *
     * @param head head
     * @return TreeNode
     */
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        top = head;
        while (top != null) {
            length++;
            top = top.next;
        }
        top = head;
        return recursiveBST(0, length - 1);
    }

    private TreeNode recursiveBST(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = recursiveBST(start, mid - 1);
        TreeNode root = new TreeNode(top.val);
        top = top.next;
        root.left = left;
        root.right = recursiveBST(mid + 1, end);
        return root;
    }
}
