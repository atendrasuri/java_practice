package com.suri.datastructure.linkedList.reverse;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/03/19
 * @Description: (Overwrite)
 *     Given a singly linked list, write a function to swap elements pairwise.
 *     For example, if the linked list is 1->2->3->4->5->6->7 then the function should change it to 2->1->4->3->6->5->7,
 *     and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
 * @History:
 */
public class ReverseLnkLstPairwise {

    public static void main(String[] args) {

        LinkedList3 list = new LinkedList3();

        list.addNode(1);list.addNode(2);list.addNode(3);list.addNode(4);list.addNode(5);
        list.displayList();

    }
}

class LinkedList3{

    class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    Node start;


    LinkedList3(){
        start=null;
    }

    public void addNode(int data){
        insertNode(data);
    }

    public void displayList(){
       // display(start);

        start = reversePairwise(start);
        display(start);
    }


    public void insertNode(int data){

        if(start==null){
            start= new Node(data);
            return;
        }

        Node temp = start;

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next= new Node(data);
    }


    public void display(Node start){

        if(start==null){
            System.out.println("List is empty");
            return;
        }

        Node temp=start;
        while(temp!=null){
            System.out.print(temp.data+"   ");
            temp= temp.next;
        }

    }


    public Node reversePairwise(Node start){

        Node p= start;
        Node q;
        Node new_start= p.next;

        while(true){
            q= p.next;
            Node temp= q.next;
            q.next=p;

            if(temp==null || temp.next==null){
                p.next= temp;
                break;
            }
            p.next=temp.next;
            p=temp;
        }
      return new_start;
    }
}

