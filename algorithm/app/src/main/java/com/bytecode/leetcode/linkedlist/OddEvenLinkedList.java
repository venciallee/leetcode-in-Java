package com.bytecode.leetcode.linkedlist;

/**
 * 328. Odd Even Linked List
 * <p>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * <p>
 * <a href="https://leetcode.com/problems/odd-even-linked-list/">328. Odd Even Linked List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/odd-even-linked-list/">328. 奇偶链表</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class OddEvenLinkedList {

    /**
     * 1. 记录head和head.next为odd和even, 把odd.next指向odd.next.next, even.next指向even.next.next
     * 2. 把odd尾结点的next指针指向even的头结点
     * <p>
     * 1. let the next of odd or even pointer to next.next
     * 2. connect the tail of the odd to the head of the even
     *
     * @param head head
     * @return ListNode
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode headOfEven = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = headOfEven;
        return head;
    }
}
