package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class AllAncestorInBinaryTree {
    public static void main(String[] args) {

        AncestorBinaryTree ancestorBinaryTree= new AncestorBinaryTree();

        ancestorBinaryTree.createTree();
        ancestorBinaryTree.display();
        System.out.println();

        System.out.println(ancestorBinaryTree.findAncestors(ancestorBinaryTree.root,4));
    }
}

class AncestorBinaryTree{

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    AncestorBinaryTree() {
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


    public boolean findAncestors(Node root, int key){

        if(root==null){
            return false;
        }

        if(root.data==key){
            return true;
        }

        if(findAncestors(root.left,key)|| findAncestors(root.right,key)){
            System.out.print(root.data+" ");
            return true;
        }

        return false;
    }

}