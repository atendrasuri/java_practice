package com.suri.datastructure.linkedList;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/09/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ReverseLinkedList {

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.addNode(12);
        list.addNode(10);
        list.addNode(4);
        list.addNode(20);
        list.addNode(30);
        list.display();
        //list.reverseList();
        //list.display();
        list.findMiddleNode();
    }

}


class LinkedList {


    class Node {
        int data;
        Node next;

        Node(int _data, Node _next) {
            data = _data;
            next = _next;
        }


    }

    Node start;

    LinkedList() {
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

    public void display() {
        if (start == null) {
            System.out.print("List is empty");
            return;
        }
        Node temp = start;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public void reverseList() {

        Node prev = start;
        Node current = start;
        Node nextNode = null;


        while (current != null) {

            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        start.next = null;
        start = prev;
    }

    public void findMiddleNode(){


        Node current =start;
        Node middle= start;

        int length =0;

        while(current.next!=null){

            length++;

            if(length%2==0){
                middle=middle.next;
            }
            current=current.next;

        }

        if(length%2!=0){
            System.out.println("middle element is " + middle.data);
            System.out.println("middle element is "+middle.next.data);
        }
        else {
            System.out.println("middle element is :- " + middle.data);
        }
    }
}