package com.bytecode.leetcode.linkedlist;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 * <a href="https://leetcode-cn.com/problems/add-two-numbers/">两数相加</a>
 * <p>
 * Created by vencial on 2019-08-19.
 */
public class AddTwoNums {

    /**
     * test case
     *
     * @param args
     */
    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = new AddTwoNums().addTwoNumbers(l1, l2);

        ListNode targetNode = new ListNode(7);
        targetNode.next = new ListNode(0);
        targetNode.next.next = new ListNode(8);
        while (listNode != null) {
            if (listNode.val != targetNode.val) {
                throw new RuntimeException("Error!");
            }
            listNode = listNode.next;
            targetNode = targetNode.next;
        }
        System.out.println("Pass!");
    }

    /**
     * 思路比较简单, 两数想加, 结果大于10, carried记录
     * 十位, 并用于下一位计算.
     * <p/>
     * Simple Solution, add two numbers, if sum is
     * bigger than ten , then record ten-digit in carried,
     * and use for next calculate.
     *
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumListNode = null;
        ListNode nextNode = null;
        int carried = 0;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
            }
            int sum = l1Val + l2Val + carried;
            int unitNum = sum % 10;
            carried = sum / 10;
            if (nextNode == null) {
                nextNode = new ListNode(unitNum);
                sumListNode = nextNode;
            } else {
                nextNode.next = new ListNode(unitNum);
                nextNode = nextNode.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carried != 0) {
            nextNode.next = new ListNode(carried);
            nextNode = nextNode.next;
        }
        return sumListNode;
    }
}
