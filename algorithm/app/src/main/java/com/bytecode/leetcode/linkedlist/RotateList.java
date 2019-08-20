package com.bytecode.leetcode.linkedlist;

/**
 * 61. Rotate List
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * <p>
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * <p>
 * <a href="https://leetcode.com/problems/rotate-list/">Rotate List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/rotate-list/">61. 旋转链表</a>
 * <p>
 * Created by vencial on 2019-08-19.
 */
public class RotateList {

    /**
     * 1. 连接, 把尾结点连接head结点
     * 2. 找到断开连接点, 即length - k % length, Example 1中的结点3
     * <p>
     * 1. connect, connect the tail and head
     * 2. cut, cut the node which is (length - k % length)
     *
     * @param head head
     * @param k    k
     * @return ListNode
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = 1;
        ListNode node = head;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        ListNode cutNode = head;
        for (int i = length - k % length - 1; i > 0; i--) {
            cutNode = cutNode.next;
        }

        node.next = head;
        node = cutNode.next;
        cutNode.next = null;
        return node;
    }
}
