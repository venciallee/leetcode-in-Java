package com.bytecode.leetcode.linkedlist;

/**
 * 725. Split Linked List in Parts
 * <p>
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * <p>
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * <p>
 * Return a List of ListNode's representing the linked list parts that are formed.
 * <p>
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * <p>
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * <p>
 * Example 2:
 * <p>
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * <p>
 * <a href="https://leetcode.com/problems/split-linked-list-in-parts/">725. Split Linked List in Parts</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/split-linked-list-in-parts/">725. 分隔链表</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class SplitLinkedListinParts {

    /**
     * @param root root
     * @param k    k
     * @return ListNode
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] list = new ListNode[k];
        int length = 0;
        ListNode node = root;
        while (node != null) {
            length++;
            node = node.next;
        }
        int part = k > length ? 1 : length / k;
        int remind = k > length ? 0 : length % k;
        for (int i = 0; i < k; i++, remind--) {
            int reminder = remind > 0 ? 1 : 0;
            ListNode splitNode = new ListNode(0);
            ListNode curNode = splitNode;
            if (root != null) {
                for (int j = 0; j < part + reminder; j++) {
                    ListNode item = root;
                    root = root.next;
                    item.next = null;
                    curNode.next = item;
                    curNode = curNode.next;
                }
            }

            list[i] = splitNode.next;

        }
        return list;
    }

}
