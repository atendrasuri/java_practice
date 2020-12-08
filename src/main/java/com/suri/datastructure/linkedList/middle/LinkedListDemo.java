package com.suri.datastructure.linkedList.middle;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insertNode(1);list.insertNode(2);list.insertNode(3);list.insertNode(4);list.insertNode(5);list.insertNode(6);

        list.display(list.start);
        System.out.println();
        list.middleNode(list.start);
    }
}


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

    LinkedList() {
        start = null;
    }


    public void insertNode(int data) {

        if (start == null) {
            start = new Node(data);
            return;
        }

        Node temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }


    public void display(Node start) {
        if (start == null) {
            System.out.println(" List is empty");
        }

        Node temp = start;
        while (temp != null) {
            System.out.print("  " + temp.data);
            temp = temp.next;
        }
    }


    public void middleNode(Node start) {


        Node fast = start;
        Node slow = fast;
        int count = 0;

        while (fast.next != null) {

            count++;
            if (count % 2 == 0) {
                slow = slow.next;
            }
            fast = fast.next;
        }

        if (count % 2!=0 ) {
            System.out.println("  " + slow.data + "  " + slow.next.data);
        } else {
            System.out.println(" " + slow.data);
        }
    }
}