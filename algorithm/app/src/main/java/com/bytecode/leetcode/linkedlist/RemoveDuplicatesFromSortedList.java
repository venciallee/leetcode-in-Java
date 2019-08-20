package com.bytecode.leetcode.linkedlist;

/**
 * 83. Remove Duplicates from Sorted List
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * <p>
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * <p>
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">83. Remove Duplicates from Sorted List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">83. 删除排序链表中的重复元素</a>
 * <p>
 * Created by vencial on 2019-08-20.
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 1. 如果找到重复结点, 把当前结点的next指向next.next
     * 2. 否则把node往前移动
     * <p>
     * 1. if find duplicate node, move next pointer to next.next
     * 2. else move node to node.next;
     *
     * @param head head
     * @return ListNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
