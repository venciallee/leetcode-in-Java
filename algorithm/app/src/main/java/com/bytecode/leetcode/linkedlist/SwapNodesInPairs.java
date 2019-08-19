package com.bytecode.leetcode.linkedlist;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">24. Swap Nodes in Pairs</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">24. 两两交换链表中的节点</a>
 * <p>
 * Created by vencial on 2019-08-19.
 */
public class SwapNodesInPairs {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode node = new SwapNodesInPairs().swapPairs(head);

        ListNode target = new ListNode(2);
        target.next = new ListNode(1);
        target.next.next = new ListNode(4);
        target.next.next.next = new ListNode(3);

        while (node != null) {
            if (node.val != target.val) {
                throw new RuntimeException("Error!");
            }
            target = target.next;
            node = node.next;
        }
        System.out.println("Pass!");
    }

    /**
     * 1. 递归与交换, 由于该题目的规律性, 可使用递归解决
     * <p>
     * 1. recursive and swap node.
     *
     * @param head head
     * @return ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
