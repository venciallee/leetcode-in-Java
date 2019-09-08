package com.bytecode.leetcode.linkedlist;

/**
 * 143. Reorder List
 * <p>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * <p>
 * <a href="https://leetcode.com/problems/reorder-list/">143. Reorder List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/reorder-list/">143. 重排链表</a>
 * <p>
 * Created by vencial on 2019-09-08.
 */
public class ReorderList {

    /**
     * 1. 找到中间结点
     * 2. 翻转中间结点到尾结点, 记为reverseNode
     * 3. 连接head以及reverseNode
     * <p>
     * 1. found the middle node
     * 2. reverse middle node
     * 3. connect the head and the reverse middle node.
     *
     * @param head head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode curNode = head;
        int length = 0;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        int mid = Math.round(length / 2);
        ListNode midNode = head;
        for (int i = 0; i < mid; i++) {
            midNode = midNode.next;
        }
        // reverse midNode
        ListNode reverseNode = null;
        ListNode tmpMidNode = midNode;
        while (tmpMidNode != null) {
            ListNode tmp = tmpMidNode.next;
            tmpMidNode.next = reverseNode;
            reverseNode = tmpMidNode;
            tmpMidNode = tmp;
        }

        curNode = head;
        for (int i = 0; i < mid; i++) {
            ListNode next = curNode.next;
            curNode.next = reverseNode;
            reverseNode = reverseNode.next;
            curNode.next.next = next;
            curNode = curNode.next.next;
        }
        // invoid cycle linkedlist
        curNode.next = null;
    }
}
