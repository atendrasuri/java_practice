package com.suri.datastructure.tree.kthInBST;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class KthLargestinBST {

    public static void main(String[] args) {

        BST bst = new BST();

        bst.insert(10);bst.insert(12);bst.insert(13);bst.insert(7);bst.insert(5);bst.insert(9);bst.insert(8);

        bst.printkth(2);


    }
}


class BST {


    class Node {
        int data;
        Node left, right;

        Node(int data) {

            this.data = data;
            left = right = null;
        }
    }


    Node root;

    BST() {
        root = null;
    }

    public void insert(int data){
        root= insertNode(root,data);
    }

    public void printkth(int k){
        Node temp = kthLargest(root, k, 0);
        System.out.println(temp.data+" ");
        //inorder(root);
    }


    public Node insertNode(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertNode(root.left, data);
        }
        if (data > root.data) {
            root.right = insertNode(root.right, data);
        }

        return root;
    }


    public void inorder(Node root){

        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+"  ");
            inorder(root.right);
        }
    }
    public Node kthLargest(Node root, int k, int count){

        if(root==null){
            return root;
        }
        Node temp =null;
        temp= kthLargest(root.right, k, count);


        if(temp==null){
            count++;
            if(count==k){
                temp =root;
            }
        }

        if(temp==null) {

            temp = kthLargest(root.left,k,count);
        }
        return temp;
    }
}