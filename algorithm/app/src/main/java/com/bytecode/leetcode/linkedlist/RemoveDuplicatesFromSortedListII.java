package com.bytecode.leetcode.linkedlist;

/**
 * 82. Remove Duplicates from Sorted List II
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 * <p>
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">82. Remove Duplicates from Sorted List II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
 * <p>
 * Created by vencial on 2019-08-20.
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * 1. 找到重复的结点, 并把重复的状态保存到duplicate变量
     * 2. 继续移动fast指针
     * 3. 如果没有重复并且duplicate为true, 则修改slow指针, 指fast.next
     * <p>
     * 1. find duplicate node, and store in variable duplicate
     * 2. move fast pointer
     * 3. if there no duplicate and variable duplicate is true,
     * then update slow pointer to fast.next.
     *
     * @param head head
     * @return ListNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode slow = dummpy;
        ListNode fast = head;
        boolean duplicate = false;
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                duplicate = true;
            } else {
                if (duplicate) {
                    slow.next = fast.next;
                    duplicate = false;
                } else {
                    slow = slow.next;
                }
            }
            fast = fast.next;
        }

        return dummpy.next;
    }
}
