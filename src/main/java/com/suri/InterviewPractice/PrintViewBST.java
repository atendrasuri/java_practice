package com.suri.InterviewPractice;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintViewBST {

    public static void main(String[] args) {

        BST bst = new BST();

        bst.insert(10);bst.insert(8);bst.insert(19);bst.insert(21);bst.insert(7);bst.insert(15);
        bst.display();

        System.out.println("Leaf node");
        bst.displayleaf();

        System.out.println("Print boundary left");
        bst.displayBoundaryleft();

        System.out.println(" print boundary right");
        bst.displayBoundaryRight();

        System.out.println(" Print Boundary View:-");
        bst.displayBoundaryView();

    }
}

class BST{

    class Node{
        int data;
        Node left;
        Node right;

        Node(int _data){
            data=_data;
            left=right=null;
        }
    }

    Node root;

    BST(){
        root = null;
    }



    public void insert(int d){
        root= insertNode(root,d);
    }

    public void display(){

        inorder(root);
    }

    public void displayleaf(){

        printLeaf(root);
    }

    public void displayBoundaryleft(){
        printBoundaryLeft(root);
    }
    public void displayBoundaryRight(){
        printBoundaryRight(root);
    }

    public void displayBoundaryView(){
        printBoundaryView(root);
    }



    public Node insertNode(Node node, int d){


        if(node==null){

            node= new Node(d);
            return node;
        }
        else if(d<node.data){
            node.left = insertNode(node.left,d);

        }
        else if(d>node.data){
            node.right = insertNode(node.right,d);
        }
        return node;
    }

    public void inorder(Node node){

        if(node!=null){
            inorder(node.left);
            System.out.println(" "+node.data);
            inorder(node.right);
        }
    }

    public void printLeaf(Node node){

        if(node!=null){
            printLeaf(node.left);
            printLeaf(node.right);

            if(node.left==null && node.right==null){
                System.out.println("  "+node.data);
            }

        }
    }

    public void printBoundaryLeft(Node node){

        if(node !=null){

            if(node.left!=null){
                System.out.println(" "+node.data );
                printBoundaryLeft(node.left);
            }
            else if(node.right!=null){
                System.out.println(" "+node.data);
                printBoundaryLeft(node.right);
            }
        }
    }

    public void printBoundaryRight(Node node){

        if(node!=null){
            if(node.right!=null){
                printBoundaryRight(node.right);
                System.out.println(" "+node.data);
            }
            else if(node.left!=null){
                printBoundaryRight(node.left);
                System.out.println(" "+node.data);
            }
        }
    }

    public void printBoundaryView(Node node){

        if(node!=null){

            System.out.println(" "+node.data);
            printBoundaryLeft(node.left);
            printLeaf(node.left);
            printLeaf(node.right);
            printBoundaryRight(node.right);
        }
    }
}