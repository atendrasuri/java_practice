package com.suri.AFlipkartInterview;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintBSTAllQ {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);bst.insert(15);bst.insert(18);bst.insert(12);bst.insert(30);bst.insert(25);bst.insert(28);
        bst.display();

    }


}

class BinarySearchTree{


        class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree(){
        root=null;
    }

    public void insert(int data){
        root= insert(root,data);
    }

    public void display(){
        printGivenRange(root, 20,28);
    }

    public Node insert(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void printGivenRange(Node root, int min, int max){

        if(root==null){
            return;
        }

        if(root.data>=min && root.data<=max){
            System.out.print(root.data+" ");
        }
        printGivenRange(root.left,min,max);
        printGivenRange(root.right, min,max);
    }

    public Node removeOutsideRange(Node root, int min, int max){

        return null;
    }
}