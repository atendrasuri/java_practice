package com.suri.datastructure.tree;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintSpiralOrderBST {

    public static void main(String[] args) {

        BST1 bst = new BST1();
        bst.insert(20);bst.insert(15);bst.insert(18);bst.insert(12);bst.insert(30);bst.insert(25);bst.insert(28);
        bst.display();

    }
}

class BST1 {


        class Node {

            int data;
            Node left, right;

            Node(int data) {
                this.data = data;
                left = right = null;
            }

        }

    Node root;

    BST1() {
        root = null;
    }


    public void insert(int data) {
        root = insertNode(root, data);
    }

    public void display() {
        printSpiral(root);

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
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }


        public void printSpiral(Node root){

            if(root== null){
                return;
            }

            Stack<Node> s1 = new Stack<>();

            Stack<Node>s2= new Stack<>();


            s1.push(root);

            while(!s1.isEmpty()|| s2.isEmpty()){


                while(!s1.isEmpty()){
                    Node temp=s1.pop();
                    System.out.print(temp.data+" ");
                    if(temp.left!=null){
                        s2.push(temp.left);
                    }
                    if(temp.right!=null){
                    s2.push(temp.right);

                    }
                }

                while(!s2.isEmpty()){
                    Node temp= s2.pop();
                    System.out.print(temp.data+" ");
                    if(temp.right!=null){
                        s1.push(temp.right);
                    }
                    if(temp.left!=null) {
                        s1.push(temp.left);
                    }
                }
            }

        }

}
