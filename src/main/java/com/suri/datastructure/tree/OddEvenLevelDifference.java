package com.suri.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class OddEvenLevelDifference {
    public static void main(String[] args) {
        OddEvenLevelTree oddEvenLevelTree = new OddEvenLevelTree();
        oddEvenLevelTree.createTree();
        oddEvenLevelTree.display();
        System.out.println();
        System.out.println(oddEvenLevelTree.getLevelDiff(oddEvenLevelTree.root));

    }
}

class OddEvenLevelTree{
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    OddEvenLevelTree() {
        root = null;
    }

    public void display(){
        inOrder(root);
    }



    public void createTree() {
        this.root = new Node(1);

        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);


        root.left = n1;
        root.right = n2;

        n1.left = n4;
        n1.right = n5;

        n4.left = n3;


    }


    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }


    int getLevelDiff(Node root){

        int level=0;
        int oddSum=0;
        int evenSum=0;

        Queue<Node> queue= new LinkedList<>();


        if(root==null){
            return 0;
        }

        queue.add(root);

        while(queue.size()>0){

            level++;
            int size= queue.size();

            while(size>0){

                Node temp= queue.remove();
                if(level%2==0){
                    evenSum= evenSum+temp.data;
                }
                else{
                    oddSum= oddSum+temp.data;
                }

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                   queue.add(temp.right);
                }
                size--;
            }
        }
        return oddSum-evenSum;
    }
}