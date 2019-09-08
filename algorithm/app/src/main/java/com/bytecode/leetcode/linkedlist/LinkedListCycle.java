package com.bytecode.leetcode.linkedlist;

/**
 * 141. Linked List Cycle
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <a href="https://leetcode.com/problems/linked-list-cycle/">141. Linked List Cycle</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle/">141. 环形链表</a>
 * <p>
 * Created by vencial on 2019-09-08.
 */
public class LinkedListCycle {

    /**
     * 1. 是用双指针遍历, 当slow指针和fast指针相遇, 即环形链表返回true
     * 2. 当fast指针或者fast.next为空, 即非环形链表, 返回false
     * <p>
     * 1. Use Two Pointer, if slow match fast, then return true
     * 2. if fast or fast.next is null, then return false.
     *
     * @param head head
     * @return boolean
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        boolean hasCycle = true;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                hasCycle = false;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return hasCycle;
    }

}
