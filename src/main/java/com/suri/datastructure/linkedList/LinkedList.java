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

class LinkedList {

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }


  Node start;

  public Node createNode(int data) {

    Node temp = new Node(data);
    return temp;
  }

  public void insert(int data) {

    Node temp = createNode(data);

    if (start == null) {
      start = temp;

      return;
    } else {

      Node p = start;
      while (p.next != null) {
        p = p.next;
      }
      p.next = temp;
      return;
    }
  }



  public void display(Node head){

    Node temp=head;

    while(temp!=null){
      System.out.print(temp.data+" ");
      temp=temp.next;
    }
  }
}