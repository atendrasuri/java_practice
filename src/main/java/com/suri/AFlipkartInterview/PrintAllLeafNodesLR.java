package com.suri.AFlipkartInterview;

import java.sql.SQLOutput;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintAllLeafNodesLR {

    public static void main(String[] args) {

        BST bst = new BST();

        bst.insert(20);bst.insert(15);bst.insert(18);bst.insert(12);bst.insert(30);bst.insert(25);bst.insert(28);
        bst.display();


    }
}

class BST{

    class Node{

        int data;
        Node left, right;

        Node(int data){
            this.data=data;
            left=right=null;
        }

    }

    Node root;

    BST(){
        root=null;
    }


    public void insert(int data){
       root=  insertNode(root,data);
    }

    public void display(){
        //inOrder(root);
        printLeavesLR(root);
        System.out.println();
        printLeavesRL(root);
    }

    public Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    /**
     *
     *
     * @param root
     */
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    /**
     * print leaf node from left to right
     *
     */

    public void printLeavesLR(Node root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        if (root.left != null) {
            printLeavesLR(root.left);
        }
        if (root.right != null) {
            printLeavesLR(root.right);
        }
    }


    public void printLeavesRL(Node root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        if (root.right != null) {
            printLeavesRL(root.right);
        }
        if (root.left != null) {
            printLeavesRL(root.left);
        }

    }


}