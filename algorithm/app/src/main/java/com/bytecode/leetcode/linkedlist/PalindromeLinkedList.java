package com.bytecode.leetcode.linkedlist;

/**
 * 234. Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * <p>
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">234. Palindrome Linked List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">234. 回文链表</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class PalindromeLinkedList {

    /**
     * 1. 找到中间结点, 分成左链表和右链表(由于奇数长度链表, 左右不匹配, 因而只需要把中间结点往前挪一个结点, 保持左右链表长度一致即可)
     * 2. 将右链表翻转
     * 3. 匹配左链表和右链表
     *
     * 1. find the middle node
     * 2. reverse right half linked list
     * 3. if left half equal right half linked list return true, else return false
     *
     * @param head head
     * @return boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode reverseNode = reverseNode(slow);
        boolean isPalindrome = true;
        while (reverseNode != null) {
            if (head.val != reverseNode.val) {
                isPalindrome = false;
                break;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return isPalindrome;
    }

    private ListNode reverseNode(ListNode head) {
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
