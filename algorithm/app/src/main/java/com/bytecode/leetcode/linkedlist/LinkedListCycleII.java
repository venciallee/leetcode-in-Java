package com.bytecode.leetcode.linkedlist;

import java.util.HashSet;

/**
 * 142. Linked List Cycle II
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii/">142. Linked List Cycle II</ad>
 * <p>
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">142. 环形链表 II</a>
 * <p>
 * Created by vencial on 2019-09-08.
 */
public class LinkedListCycleII {

    /**
     * 1. 使用HashSet记录访问的结点, 如果有已访问结点, 即是环形链表, 返回当前结点
     * <p>
     * 1. use hashset store visited node, if set contains node, then return current visited node.
     *
     * @param head head
     * @return ListNode
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        HashSet<ListNode> visited = new HashSet<>();
        ListNode prev = null;
        while (head != null) {
            if (visited.contains(head)) {
                prev = head;
                break;
            }
            visited.add(head);
            head = head.next;
        }
        return prev;
    }

}
