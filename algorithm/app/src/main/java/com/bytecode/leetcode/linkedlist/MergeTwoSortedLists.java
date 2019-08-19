package com.bytecode.leetcode.linkedlist;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be
 * made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * <p>
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 * Created by vencial on 2019-08-19.
 */
public class MergeTwoSortedLists {

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode node = new MergeTwoSortedLists().mergeTwoLists(l1, l2);

        ListNode targetNode = new ListNode(1);
        targetNode.next = new ListNode(1);
        targetNode.next.next = new ListNode(2);
        targetNode.next.next.next = new ListNode(3);
        targetNode.next.next.next.next = new ListNode(4);
        targetNode.next.next.next.next.next = new ListNode(4);

        while (node != null) {
            if (node.val != targetNode.val) {
                throw new RuntimeException("Error!");
            }
            node = node.next;
            targetNode = targetNode.next;
        }
        System.out.println("Pass!");
    }

    /**
     * 1. l1 && l2 不为空, 如果l1较小, 新的链表指向l1当前结点,
     * l1 = l1.next, node = node.next;否则指向l2当前结点
     * 2. 循环结束后, 由于l1或l2可能不为空, node.next还需要指向不为空的链表
     * <p>
     * 1. if l1 and l2 is not null, then node.next pointer to the small node in l1 or l2,
     * and l1 = l1.next, node = node.next
     * 2. at the end of the loop, node.next ponter must point to the l1 or l2 if one of them are not empty.
     *
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1 != null ? l1 : l2;

        return dummy.next;
    }
}
