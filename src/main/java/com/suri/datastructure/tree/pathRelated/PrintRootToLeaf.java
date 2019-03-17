package com.suri.datastructure.tree.pathRelated;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintRootToLeaf {

    public static void main(String[] args) {

        BTRootToLeaf bst = new BTRootToLeaf();
        bst.insertNode(6);bst.insertNode(13);bst.insertNode(16);bst.insertNode(20);bst.insertNode(21);bst.insertNode(15);
        bst.insertNode(5);bst.insertNode(14);bst.insertNode(8);bst.insertNode(9);
        bst.printRootToLeaf();

    }
}


class BTRootToLeaf{

    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data= data;
        }
    }

    Node root;
    String path;

    BTRootToLeaf(){
        root=null;
    }

    public void insertNode(int data){
        root= insert(root, data);
    }

    public void display(){

        //  inOrder(root);
    }

    public void printRootToLeaf(){

        Stack<Integer> stack = new Stack<>();
        rootToLeafPath(root,stack );
    }



    public Node insert(Node node, int data){

        if(node==null){
            node= new Node(data);
            return node;
        }

        if(data>node.data){
            node.right= insert(node.right,data);
        }
        else if(data<node.data){
            node.left= insert(node.left,data);
        }
        return node;

    }

    public void inOrder(Node root){
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }



    public void rootToLeafPath(Node root, Stack<Integer> stack){

        if (root == null) {
            return;
        }
        stack.push(root.data);

        rootToLeafPath(root.left, stack);

            if (root.left == null && root.right == null) {

                while (stack.size() > 0) {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println();
            }
        rootToLeafPath(root.right, stack);

        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
}