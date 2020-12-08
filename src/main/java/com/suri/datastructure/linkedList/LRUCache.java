package com.suri.datastructure.linkedList;

import java.util.HashMap;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 29/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
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
 * LRUCache cache = new LRUCache( 2 /* capacity
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
 */
public class LRUCache {
  public static void main(String[] args) {
    LRUCacheImpl lruCache = new LRUCacheImpl(2);

    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));       // returns 1
    lruCache.put(3, 3);    // evicts key 2
    System.out.println(lruCache.get(2));       // returns -1 (not found)
    lruCache.put(4, 4);    // evicts key 1
    System.out.println(lruCache.get(1));       // returns -1 (not found)
    System.out.println(lruCache.get(3));      // returns 3
    System.out.println(lruCache.get(4));

  }
}

class LRUCacheImpl {

  class DNode {
    int key;
    int val;
    DNode prev;
    DNode next;

    DNode() {

    }

    DNode(int key, int val) {
      this.key = key;
      this.val = val;
      prev = null;
      next = null;
    }

  }

  private HashMap<Integer, DNode> map = new HashMap<>();
  private DNode head;
  private DNode tail;
  private int totalItemInCache;
  private int capacity;

  LRUCacheImpl(int capacity) {
    this.totalItemInCache = 0;
    this.capacity = capacity;

    head = new DNode();
    head.prev = null;

    tail = new DNode();
    tail.next = null;

    head.next = tail;
    tail.prev = head;

  }

  public int get(int key) {
    DNode node = map.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.val;
  }

  public void put(int key, int value) {

    DNode node = map.get(key);
    if (node == null) {
      DNode newNode = new DNode(key, value);
      map.put(key, newNode);
      addNode(newNode);
      totalItemInCache++;
      if (totalItemInCache > capacity) {
        removeLRUItem();
      }
    } else {
      node.val = value;
      moveToHead(node);
    }

  }

  private void removeLRUItem() {

    DNode tail = popTail();
    map.remove(tail.key);
    totalItemInCache--;
  }


  private void addNode(DNode newNode) {

    newNode.prev = head;
    newNode.next = head.next;
    head.next.prev = newNode;
    head.next = newNode;
  }


  private void moveToHead(DNode node) {
    removeNode(node);
    addNode(node);
  }

  private void removeNode(DNode node) {

    DNode savePrev = node.prev;
    DNode saveNext = node.next;

    savePrev.next = saveNext;
    saveNext.prev = savePrev;
  }


  private DNode popTail() {
    DNode itemBeingRemoved = tail.prev;
    removeNode(itemBeingRemoved);
    return itemBeingRemoved;
  }
}