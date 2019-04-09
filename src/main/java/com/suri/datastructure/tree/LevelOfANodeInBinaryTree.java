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
public class LevelOfANodeInBinaryTree {
    public static void main(String[] args) {

        LevelOfANodeBinaryTree levelOfANodeBinaryTree= new LevelOfANodeBinaryTree();
        levelOfANodeBinaryTree.createTree();
        levelOfANodeBinaryTree.display();
        System.out.println();
        System.out.println(levelOfANodeBinaryTree.findLevel(levelOfANodeBinaryTree.root,4,0));

    }
}


class LevelOfANodeBinaryTree{

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    LevelOfANodeBinaryTree() {
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


    public int findLevel(Node root, int key, int level){

        if(root==null){
            return 0;
        }

        if(root.data==key){
            return level;
        }
        int l= findLevel(root.left,key,level+1);
        if(l!=0){
            return l;
        }
        int r= findLevel(root.right,key,level+1);

        return r;
    }



}

