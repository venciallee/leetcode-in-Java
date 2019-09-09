package com.bytecode.leetcode.linkedlist;

/**
 * 445. Add Two Numbers II
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * <p>
 * <a href="https://leetcode.com/problems/add-two-numbers-ii/">445. Add Two Numbers II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/add-two-numbers-ii/">445. 两数相加 II</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class AddTwoNumbersII {

    /**
     * 1. 把l1, l2翻转
     * 2. 结点值相加
     * 3. 把结果链表再翻转
     * <p>
     * 1. reverse l1 and l2
     * 2. add l1.val and l2.val
     * 3. reverse result linked list again
     *
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int remind = 0;
        ListNode dummpy = new ListNode(0);
        ListNode node = dummpy;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remind;
            if (sum >= 10) {
                remind = sum / 10;
            } else {
                remind = 0;
            }
            node.next = new ListNode(sum % 10);
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (remind > 0) {
            node.next = new ListNode(remind);
        }
        dummpy.next = reverse(dummpy.next);
        return dummpy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
}
