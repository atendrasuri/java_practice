package com.suri.datastructure.linkedList;

import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 02/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * <p>
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
  public static void main(String[] args) {

    LinkedLists linkedLists1 = new LinkedLists();

    linkedLists1.insertNode(1);
    linkedLists1.insertNode(4);
    linkedLists1.insertNode(5);

    LinkedLists linkedLists2 = new LinkedLists();

    linkedLists2.insertNode(1);
    linkedLists2.insertNode(3);
    linkedLists2.insertNode(4);

    LinkedLists linkedLists3 = new LinkedLists();

    linkedLists3.insertNode(2);
    linkedLists3.insertNode(6);

    LinkedLists.ListNode[] lists = new LinkedLists.ListNode[3];

    lists[0] = linkedLists1.head;

    lists[1] = linkedLists2.head;
    lists[2] = linkedLists3.head;

    LinkedLists res = new LinkedLists();
    LinkedLists.ListNode head4 = res.mergeKLists(lists);

    res.display(head4);
  }
}

class LinkedLists {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {

      this.val = val;
      next = null;
    }

  }


  ListNode head;

  LinkedLists() {
    head = null;
  }


  public void display(ListNode start) {
    if (start == null) {
      System.out.println(" List is empty");
    }

    ListNode temp = start;
    while (temp != null) {
      System.out.print("  " + temp.val);
      temp = temp.next;
    }
  }

  public void insertNode(int data) {

    if (head == null) {
      head = new ListNode(data);
      return;
    }

    ListNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new ListNode(data);
  }


  public ListNode mergeKLists(ListNode[] lists) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (ListNode head : lists) {
      while (head != null) {
        minHeap.add(head.val);
        head = head.next;
      }
    }

    ListNode dummy = new ListNode(-1);
    ListNode head = dummy;

    while (!minHeap.isEmpty()) {

      head.next = new ListNode(minHeap.remove());
      head = head.next;
    }
    return dummy.next;
  }
}