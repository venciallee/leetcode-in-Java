package com.bytecode.leetcode.linkedlist;

/**
 * 147. Insertion Sort List
 * <p>
 * Sort a linked list using insertion sort.
 * <p>
 * <p>
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p>
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * <p>
 * <a href="https://leetcode.com/problems/insertion-sort-list/">147. Insertion Sort List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/insertion-sort-list/">147. 对链表进行插入排序</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class InsertionSortList {

    /**
     * 比较简单, 用已排序链表记录已排序值, 将未排序的结点放到已排链表
     * <p>
     * insertion algorithm, use a sorted linked list
     *
     * @param head head
     * @return ListNode
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedList = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode slow = sortedList;
            ListNode cur = sortedList.next;
            while (cur != null && cur.val < head.val) {
                cur = cur.next;
                slow = slow.next;
            }

            slow.next = head;
            head = head.next;
            slow.next.next = cur;
        }
        return sortedList.next;
    }
}
