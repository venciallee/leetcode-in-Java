package com.bytecode.leetcode.linkedlist;

import java.util.HashMap;

/**
 * 138. Copy List with Random Pointer
 * <p>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 * <p>
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">138. Copy List with Random Pointer</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/copy-list-with-random-pointer/">138. 复制带随机指针的链表</a>
 * <p>
 * Created by vencial on 2019-09-08.
 */
public class CopyListwithRandomPointer {

    private HashMap<Node, Node> map = new HashMap<>();

    /**
     * 1. 递归并遍历生成Node
     * 2. 避免random指针循环问题, 使用HashMap记录生成的结点, 如果已生成, 即在HashMap上存在对应结点, 则返回已生成结点
     *
     * 1. recursive and create Node
     * 2. use hashmap to store created node.
     *
     * @param head head
     * @return Node
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        Node node = new Node();
        node.val = head.val;
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}
