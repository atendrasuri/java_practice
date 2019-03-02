package com.suri.datastructure.linkedList;

import java.util.HashSet;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
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

        list.addNode(6);
        list.addNode(7);
        list.addNode(8);
        list.addNode(9);

        list.display(list.start );

        //list.start = list.reverse(list.start,2);
       list.start = list.reversePairWise(list.start);
        System.out.println();

        list.display(list.start );

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

    public  Node reverse(Node start,int k){


        HashSet set;
        int count =0;
        Node current = start;
        Node prev = null;
        Node next =null;

        while(count<k && current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;

        }

        if (next != null)
            start.next = reverse(next, k);

        return prev;
    }


    public Node reversePairWise(Node start){


        Node p=start;
        Node q;
        Node new_star=p.next;


        while (true) {
            q = p.next;
            Node temp = q.next;
            q.next = p;

            if (temp == null || temp.next == null) {
                p.next= temp;
                break;
            }
            p.next = temp.next;
            p = temp;

        }
    return new_star;
    }
}