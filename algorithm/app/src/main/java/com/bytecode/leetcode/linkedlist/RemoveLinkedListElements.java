package com.bytecode.leetcode.linkedlist;

/**
 * 203. Remove Linked List Elements
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * <p>
 * <a href="https://leetcode.com/problems/remove-linked-list-elements/">203. Remove Linked List Elements</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/remove-linked-list-elements/">203. 移除链表元素</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class RemoveLinkedListElements {

    /**
     * 使用slow指针指向当前结点的上一个结点, 当前结点和指定值相等, 则连接slow指针和当前结点的next指针
     * <p>
     * if the value of current node is equal val, then connect previous node and next node
     *
     * @param head head
     * @param val  val
     * @return ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode slow = dummpy;
        while (head != null) {
            if (head.val == val) {
                slow.next = head.next;
            } else {
                slow = slow.next;
            }
            head = head.next;
        }

        return dummpy.next;
    }

}
