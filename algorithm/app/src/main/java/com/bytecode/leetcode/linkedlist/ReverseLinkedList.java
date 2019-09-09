package com.bytecode.leetcode.linkedlist;

/**
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206. 反转链表</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class ReverseLinkedList {

    /**
     * Reverse
     *
     * @param head head
     * @return ListNode
     */
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }

}
