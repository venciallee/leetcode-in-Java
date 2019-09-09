package com.bytecode.leetcode.linkedlist;

/**
 * 876. Middle of the Linked List
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list/">876. 链表的中间结点</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class MiddleoftheLinkedList {

    /**
     * 双指针
     * <p>
     * two pointer
     *
     * @param head head
     * @return ListNode
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
