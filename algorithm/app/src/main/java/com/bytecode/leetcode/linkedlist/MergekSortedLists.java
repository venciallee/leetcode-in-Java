package com.bytecode.leetcode.linkedlist;

/**
 * 23. Merge k Sorted Lists
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * <p>
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并K个排序链表</a>
 * Created by vencial on 2019-08-19.
 */
public class MergekSortedLists {

    /**
     * Simple Test Case.
     *
     * @param args args
     */
    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode lists[] = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode node = new MergekSortedLists().mergeKLists(lists);

        ListNode target = new ListNode(1);
        target.next = new ListNode(1);
        target.next.next = new ListNode(2);
        target.next.next.next = new ListNode(3);
        target.next.next.next.next = new ListNode(4);
        target.next.next.next.next.next = new ListNode(4);
        target.next.next.next.next.next.next = new ListNode(5);
        target.next.next.next.next.next.next.next = new ListNode(6);
        while (node != null) {
            if (node.val != target.val) {
                throw new RuntimeException("Error!");
            }
            node = node.next;
            target = target.next;
        }
        System.out.println("Pass!");
    }

    /**
     * 1. Divide: 把lists数组分成两部分, 递归调用, 直到lists的长度小于等于2
     * 2. Conquer: 如果lists数组长度等于0则返回null, 如果lists数组长度等于1, 返回本身, 否则合并2个链表并返回
     * <p>
     * 1. Divide: splite lists to two part, and recursive till the length of lists is less than or equal to 2
     * 2. Conquer: merge every two linkedlist and return. if length of list is zero then return null,
     * or length of list is one then return itself.
     *
     * @param lists lists
     * @return ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return lists[0];
        } else if (length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int mid = length / 2;
        ListNode[] lowerList = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            lowerList[i] = lists[i];
        }

        ListNode[] higherList = new ListNode[length - mid];
        for (int i = mid, j = 0; i < length; i++, j++) {
            higherList[j] = lists[i];
        }

        return mergeTwoLists(mergeKLists(lowerList), mergeKLists(higherList));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummpy = new ListNode(0);
        ListNode node = dummpy;
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

        return dummpy.next;
    }
}
