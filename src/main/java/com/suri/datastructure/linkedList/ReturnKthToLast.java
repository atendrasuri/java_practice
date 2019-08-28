package com.suri.datastructure.linkedList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 27/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ReturnKthToLast {
  static int i = 0;

  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList();
    linkedList.insert(10);
    linkedList.insert(15);
    linkedList.insert(20);
    linkedList.insert(25);
    linkedList.insert(25);
    linkedList.insert(30);
    linkedList.insert(35);
    linkedList.insert(35);
    linkedList.insert(40);
    linkedList.display(linkedList.start);
    System.out.println();
    printNthFromlastRecursive(linkedList.start,3);

    System.out.println();
    System.out.println(printNthFromlast(linkedList.start,3).data);


  }

  public static void printNthFromlastRecursive(LinkedList.Node head, int n) {

    if (head == null) {
      return;
    }
    printNthFromlastRecursive(head.next, n);
    if (++i == n) {
      System.out.println(head.data);
    }

  }

  public static LinkedList.Node printNthFromlast(LinkedList.Node head, int n) {

    LinkedList.Node slow = head;
    LinkedList.Node fast = head;
    int i = 0;
    while (++i < n && fast.next != null) {
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}