package com.suri.InterviewPractice;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ReverseLinkedListK {

    public static void main(String[] args) {

        LinkedList list= new LinkedList();
        LinkedList list1= new LinkedList();
        list.insertNode(5);
        list.insertNode(7);
        list.insertNode(17);
        list.insertNode(13);
        list.insertNode(11);


        list1.insertNode(12);
        list1.insertNode(10);
        list1.insertNode(2);
        list1.insertNode(4);
        list1.insertNode(6);


        list.display(list.start);
        System.out.println("second list");
        list1.display(list1.start);
        list.mergeTwoLinkedList(list.start,list1.start);
        //list.display(list.start);


        /*list.reverseKNode(2);
        System.out.println("after reverse");
        list.display();
*/


    }
}

class LinkedList{


    class Node{
        int data;
        Node next;

        Node(int data, Node next){
            this.data=data;
            this.next=next;
        }

    }

    Node start;

    LinkedList(){
        start=null;
    }

    public void reverseKNode(int k){
        start= reverseK(start,k);
    }

    public void insertNode(int data){
        if(start==null){
            start = new Node(data,null);
        }
        else{
            Node temp=start;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next= new Node(data,null);
        }
    }

    public void display(Node start){

        if(start==null){
            System.out.println("List is empty");
            return;
        }

        Node temp=start;
        while(temp!=null){
            System.out.println(""+temp.data);
            temp=temp.next;
        }

    }

    public Node reverseK(Node start,int k){

        if(start==null){
            System.out.println("List is empty");
            return null;
        }

        Node prev=null;
        Node nextNode=null;
        Node current=start;
        int count =0;

        while(count<k && current!=null){

            nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
            count++;


        }

        if(nextNode!=null)
        {
            start.next=reverseK(nextNode,k);
        }

        return prev;
    }


    public void mergeTwoLinkedList(Node start1, Node start2){


        if(start2==null){
            System.out.println("second linked list is empty");
            return;
        }
        Node temp1= start1;
        Node temp2= start2;

        while(temp2!=null){

            Node node1 = temp1.next;
            Node node2= temp2.next;
            temp1.next= temp2;
            temp2.next=node1;

            temp1= node1;
            temp2=node2;

        }

        System.out.println("merge---");
        display(start1);
    }

}