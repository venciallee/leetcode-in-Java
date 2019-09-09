package com.bytecode.leetcode.linkedlist;

/**
 * 160. Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <p>
 * begin to intersect at node c1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">160. Intersection of Two Linked Lists</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">160. 相交链表</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

}
