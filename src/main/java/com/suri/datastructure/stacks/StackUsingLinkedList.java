package com.suri.datastructure.stacks;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/09/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class StackUsingLinkedList {

    public static void main(String str[])
    {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(10);
        stack.push(5);
        stack.push(20);

        stack.peep();
    }
}


class Stack{

    class Node{
        int data;
        Node next;
        Node(int _data, Node _next){
            data=_data;
            next = _next;
        }

    }

    Node top;
    Stack(){
        top= null;
    }

    public void push(int data){
        Node temp = new Node(data,null);
        temp.next=top;
        top =temp;
    }

    public void peep(){
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}