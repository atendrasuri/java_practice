package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class VerticalPrintBST{

    public static void main(String[] args) {

        BinaryTree bst = new BinaryTree();
        bst.createBST(1); bst.createBST(2); bst.createBST(3); bst.createBST(4); bst.createBST(5);
        bst.createBST(6);bst.createBST(7);bst.createBST(8);bst.createBST(9);bst.createBST(10);
        bst.displayInorder();

    }
}


class BinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

    }

    Node root;

    BinaryTree() {

        root = null;
    }

    /*
      utility methods
     */

    public void createBST(int data){
        root = createNode(root,data);
    }

    public void displayInorder(){
        inOrder(root);
    }

    public Node createNode(Node node,int data){
        if(node==null){
            node = new Node(data);
            return node;
        }
        if(data>node.data){
            node.right = createNode(node.right,data);
        }
        if(data<node.data){
            node.left= createNode(node.left,data);
        }
        return node;
    }


    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.println("  "+node.data);
            inOrder(node.right);
        }
    }
}