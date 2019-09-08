package com.bytecode.leetcode.linkedlist;

/**
 * 92. Reverse Linked List II
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * <p>
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">92. Reverse Linked List II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">92. 反转链表 II</a>
 * <p>
 * Created by vencial on 2019-09-08.
 */
public class ReverseLinkedListII {

    /**
     * 1. 找到m-1位置的Node作为插入的prev结点
     * 2. 从m到n一步步交换, m+1到n的结点插入到prev结点之后,
     * m结点则往后挪
     * <p>
     * 1. search the prev Node which position at m - 1
     * 2. swap node from m to n step by step, the node in position m+1 to n insert behind prev node,
     *
     * @param head head
     * @param m    m
     * @param n    n
     * @return ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode prev = dummpy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode next = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = start.next;
        }

        return dummpy.next;
    }

}
