package com.suri.datastructure.tree;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DepthOfBst {

    public static void main(String[] args) {

        BST bst = new BST();
        bst.insertNode(10);
        bst.insertNode(20);
        bst.insertNode(40);
        bst.insertNode(60);
        bst.insertNode(15);
        bst.insertNode(12);
        bst.insertNode(13);
        bst.insertNode(24);

        bst.display();
        System.out.println("total no of node:- " + bst.totalNoNode());
        System.out.println("height of BST is :- " + bst.findHeight());

        //bst.findKthLargest(1);
        bst.findKthSmallest(1);

    }
}


class BST {


    class Node {

        Node left;
        Node right;
        int data;

        Node(int _data) {
            data = _data;
            left = right = null;
        }

    }

    Node root;

    static int counter;

    BST() {
        root = null;
    }

    public void insertNode(int data) {

        root = insert(root, data);
    }

    public void display() {

        inOrder(root);
    }

    public int totalNoNode() {

        return countNode(root);
    }

    public int findHeight() {
        return heightofBST(root);
    }


    public void findKthLargest(int k){

        Node node = kthLargestElement(root,k);

        System.out.println(node.data);
    }

    public void findKthSmallest(int k){

        Node node = kthSmallestElement(root,k);

        System.out.println(node.data);
    }
    public Node insert(Node node, int data) {

        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);

        }

        return node;
    }


    public void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }

    }


    public int countNode(Node node) {
        if (node == null) {
            return 0;
        }

        return countNode(node.left) + countNode(node.right) + 1;


    }

    public int heightofBST(Node node) {

        if (node == null) {
            return 1;
        }

        int lheight = heightofBST(node.left);

        int rheight = heightofBST(node.right);

        return Math.max(lheight, rheight) + 1;
    }

    public Node kthLargestElement(Node node, int k) {

        if (node == null) {
            return null;
        }


        Node node1 = kthLargestElement(node.right, k);

        if (counter != k) {
            counter++;
            node1 = node;
        }

        if (counter == k) {
            return node1;

        } else {
            return kthLargestElement(node.left, k);
        }


    }


    public Node kthSmallestElement(Node node, int k) {

        if (node == null) {
            return null;
        }


        Node node1 = kthSmallestElement(node.left, k);

        if (counter != k) {
            counter++;
            node1 = node;
        }

        if (counter == k) {
            return node1;

        } else {
            return kthSmallestElement(node.right, k);
        }


    }
}