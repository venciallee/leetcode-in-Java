package com.bytecode.leetcode.linkedlist;

/**
 * 86. Partition List
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * <p>
 * <a href="https://leetcode.com/problems/partition-list/">86. Partition List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/partition-list/">86. 分隔链表</a>
 * <p>
 * Created by vencial on 2019-09-07.
 */
public class PartitionList {

    /**
     * 1. 双指针解法, 拆分, 一个指向比x小的数, 一个指向比x大的数
     * 2. 合并, 把小数pointer尾指向大数pointer头, 并把大数pointer尾置为null, 以免循环链表
     *
     * 1. Two pointer solution, step 1, divide, put the node less than x to the smaller pointer, otherwise,
     * put the other node to the bigger pointer
     * 2. step 2, combine the tail of the smaller pointer to the head of the bigger pointer
     *
     * @param head head
     * @param x x
     * @return ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummpy = new ListNode(0), biggerDummpy = new ListNode(0);
        ListNode smaller = dummpy, bigger = biggerDummpy;
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = head;
            } else {
                bigger.next = head;
                bigger = head;
            }
            head = head.next;
        }
        bigger.next = null;
        smaller.next = biggerDummpy.next;

        return dummpy.next;
    }
}
