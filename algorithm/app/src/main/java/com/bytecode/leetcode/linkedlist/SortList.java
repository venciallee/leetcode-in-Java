package com.bytecode.leetcode.linkedlist;

/**
 * 148. Sort List
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * <p>
 * <a href="https://leetcode.com/problems/sort-list/">148. Sort List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/sort-list/">148. 排序链表</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class SortList {

    /**
     * 1. 使用双指针, 找到链表中间结点, 截断链表
     * 2. 用归并排序算法, 把左链表和右链表合并
     * <p>
     * 1. Cut the linked list to left part and right part by using two node
     * 2. merge left linked list & right linked list
     *
     * @param head head
     * @return ListNode
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode midNode = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            midNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut the list
        midNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode sortList = new ListNode(0);
        ListNode curNode = sortList;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curNode.next = left;
                left = left.next;
            } else {
                curNode.next = right;
                right = right.next;
            }
            curNode = curNode.next;
        }
        if (left != null) {
            curNode.next = left;
        }
        if (right != null) {
            curNode.next = right;
        }

        return sortList.next;
    }

}
