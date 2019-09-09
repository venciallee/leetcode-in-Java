package com.bytecode.leetcode.linkedlist;

import java.util.HashSet;

/**
 * 817. Linked List Components
 * <p>
 * We are given head, the head node of a linked list containing unique integer values.
 * <p>
 * We are also given the list G, a subset of the values in the linked list.
 * <p>
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 * <p>
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * <p>
 * <a href="https://leetcode.com/problems/linked-list-components/">817. Linked List Components</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/linked-list-components/">817. 链表组件</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class LinkedListComponents {

    /**
     * hashset
     *
     * @param head head
     * @param G G
     * @return int
     */
    public int numComponents(ListNode head, int[] G) {
        int nums = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                nums++;
            }
            head = head.next;
        }
        return nums;
    }
}
