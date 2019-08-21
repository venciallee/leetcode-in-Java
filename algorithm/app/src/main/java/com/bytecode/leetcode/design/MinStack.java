package com.bytecode.leetcode.design;

/**
 * 155. Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * - push(x) -- Push element x onto stack.
 * - pop() -- Removes the element on top of the stack.
 * - top() -- Get the top element.
 * - getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * <p>
 * <a href="https://leetcode.com/problems/min-stack/">155. Min Stack</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/min-stack/">155. 最小栈</a>
 * <p>
 * Created by vencial on 2019-08-21.
 */
public class MinStack {

    private Node head;
    private int count;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    /**
     * single linkedNode solution
     *
     * @param x x
     */
    public void push(int x) {
        if (head == null) {
            head = new Node(x);
            count++;
        } else {
            Node node = new Node(x);
            node.next = head;
            head = node;
            count++;
        }
    }

    /**
     * move head to the next
     */
    public void pop() {
        if (count > 0) {
            head = head.next;
            count--;
        }
    }

    public int top() {
        if (count > 0) {
            return head.value;
        }

        return -1;
    }

    public int getMin() {
        Node node = head;
        int result = Integer.MAX_VALUE;
        while (node != null) {
            if (node.value < result) {
                result = node.value;
            }
            node = node.next;
        }

        return result;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
