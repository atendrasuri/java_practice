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
public class DeleteDuplicateNodes {
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
    deleteDups(linkedList.start);
    System.out.println();
    linkedList.display(linkedList.start);


  }
  public static void deleteDups(LinkedList.Node head){

    LinkedList.Node current= head;
    while(current!=null){


      LinkedList.Node runner= current;

      while(runner.next!=null){
        if(runner.next.data==current.data){
          runner.next=runner.next.next;
        }else{
          runner=runner.next;
        }
      }
      current=current.next;
    }
  }
}
