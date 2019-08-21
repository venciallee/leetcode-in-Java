package com.bytecode.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 // capacity );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * <p>
 * <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/lru-cache/">146. LRU缓存机制</a>
 * Created by vencial on 2019-08-20.
 */
public class LRUCache {


    private Map<Integer, Node> mCache;
    private int mCapacity;
    private Node head, tail;
    private int count;

    public LRUCache(int capacity) {
        mCache = new HashMap<>(capacity);
        mCapacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    /**
     * 1. Get Node from HashMap by key
     * 2. if exists, update the node order
     *
     * @param key key
     * @return int
     */
    public int get(int key) {
        if (mCache.get(key) != null) {
            Node node = mCache.get(key);
            deleteNode(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }

    /**
     * 1. if key exists in map, update the node's value, then update the node order
     * 2. else, if count is bigger than capacity, remove last node and add the new one to the head,
     * or just add new node to the head.
     *
     * @param key   key
     * @param value value
     */
    public void put(int key, int value) {
        if (mCache.get(key) != null) {
            Node node = mCache.get(key);
            node.value = value;
            deleteNode(node);
            addNode(node);
        } else {
            Node node = new Node(key, value);
            mCache.put(key, node);
            if (count >= mCapacity) {
                mCache.remove(tail.prev.key);
                deleteNode(tail.prev);
                addNode(node);
            } else {
                addNode(node);
                count++;
            }
        }
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
