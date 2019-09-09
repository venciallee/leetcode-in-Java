package com.bytecode.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 1019. Next Greater Node In Linked List
 * <p>
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 * <p>
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 * <p>
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 * <p>
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,5]
 * Output: [5,5,0]
 * Example 2:
 * <p>
 * Input: [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 * Example 3:
 * <p>
 * Input: [1,7,5,1,9,2,5,1]
 * Output: [7,9,9,9,0,5,0,0]
 * <p>
 * <a href="https://leetcode.com/problems/next-greater-node-in-linked-list/">1019. Next Greater Node In Linked List</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/next-greater-node-in-linked-list/">1019. 链表中的下一个更大节点</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class NextGreaterNodeInLinkedList {

    /**
     * stack
     *
     * @param head head
     * @return int[]
     */
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] largerNums = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                largerNums[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return largerNums;
    }
}
