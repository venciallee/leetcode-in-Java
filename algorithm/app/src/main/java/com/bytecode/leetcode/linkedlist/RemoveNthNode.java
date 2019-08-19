package com.bytecode.leetcode.linkedlist;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>
 * <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第N个节点</a>
 * <p>
 * Created by vencial on 2019-08-19.
 */
public class RemoveNthNode {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node = new RemoveNthNode().removeNthFromEnd(head, 2);

        ListNode target = new ListNode(1);
        target.next = new ListNode(2);
        target.next.next = new ListNode(3);
        target.next.next.next = new ListNode(5);
        while (node != null) {
            if (node.val != target.val) {
                throw new RuntimeException("Error!");
            }
            target = target.next;
            node = node.next;
        }
        System.out.println("Pass!");
    }

    /**
     * 1. 计算链表长度
     * 2. 获取上一个结点, 即length - n, 此题的结点为3,
     * 3. 修改上一个结点的next指针, next指向next.next
     * <p>
     * 1. count the length of ListNode
     * 2. get the previous ListNode, it should be length of ListNode minus n,
     * 3. update the next pointer in previous ListNode, to next.next
     *
     * @param head head
     * @param n    n
     * @return ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode targetNode = new ListNode(0);
        targetNode.next = head;
        ListNode prev = head;
        int length = 0;
        while (prev != null) {
            length++;
            prev = prev.next;
        }
        length -= n;
        prev = targetNode;
        while (length > 0) {
            length--;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return targetNode.next;
    }
}


