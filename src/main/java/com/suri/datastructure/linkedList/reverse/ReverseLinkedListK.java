package com.suri.datastructure.linkedList.reverse;

import java.util.HashSet;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/11/18
 * @Description: (Overwrite)
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * @History:
 */
public class ReverseLinkedListK {
  public static void main(String[] args) {

    LinkedList1 list = new LinkedList1();
    list.addNode(1);
    list.addNode(2);
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);

       /* list.addNode(6);
        list.addNode(7);
        list.addNode(8);*/
    //list.addNode(9);

    list.display(list.start);

    list.start = list.reverseKGroup(list.start, 3);
    //list.start = list.reversePairWise(list.start);
    System.out.println();

    list.display(list.start);

  }


}

class LinkedList1 {


  class Node {
    int data;
    Node next;

    Node(int _data, Node _next) {
      data = _data;
      next = _next;
    }


  }

  Node start;

  LinkedList1() {
    start = null;
  }

  public void addNode(int data) {

    if (start == null) {
      Node node = new Node(data, null);
      start = node;
    } else {
      Node temp = start;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = new Node(data, null);
    }
  }

  public void display(Node start) {
    if (start == null) {
      System.out.print("List is empty");
      return;
    }
    Node temp = start;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public Node reverseKGroup(Node head, int k) {

    if (head == null || head.next == null) {
      return head;
    }


    Node prev = null;
    Node next = head;
    Node current = head;
    int count = 0;


    for (int i = 0; i < k; i++) {
      if (next == null)
        return head;

      next = next.next;
    }
    while (current != null && count < k) {

      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    if (next != null) {
      head.next = reverseKGroup(next, k);
    }

    return prev;
  }


  public Node reversePairWise(Node start) {


    Node p = start;
    Node q;
    Node new_start = p.next;


    while (true) {
      q = p.next;
      Node temp = q.next;
      q.next = p;

      if (temp == null || temp.next == null) {
        p.next = temp;
        break;
      }
      p.next = temp.next;
      p = temp;

    }
    return new_start;
  }
}