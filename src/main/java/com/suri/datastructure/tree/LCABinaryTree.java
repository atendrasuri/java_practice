package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/04/19
 * @Description: (Overwrite)
Given a Binary Tree and 2 nodes value n1 and n2 , your task is to find the lowest common ancestor of the two nodes. You are required to complete the function LCA .
You should not read any input from stdin/console.
There are multiple test cases. For each test case, this method will be called individually.
 */
public class LCABinaryTree {
    public static void main(String[] args) {

        LCABinaryTreeNode lcaBinaryTreeNode= new LCABinaryTreeNode();

        lcaBinaryTreeNode.createTree();
        lcaBinaryTreeNode.display();
        System.out.println();

        LCABinaryTreeNode.Node res = lcaBinaryTreeNode.LCA(lcaBinaryTreeNode.root, 2, 3);
        System.out.println(res.data);
    }
}

class LCABinaryTreeNode{

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    LCABinaryTreeNode() {
        root = null;
    }

    public void display(){
        inOrder(root);
    }



    public void createTree() {
        this.root = new Node(1);

        Node n1 = new Node(2);
        Node n2 = new Node(3);
        /*Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);*/


        root.left = n1;
        root.right = n2;

       /* n1.left = n4;
        n1.right = n5;

        n4.left = n3;*/


    }


    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }

    Node LCA(Node root, int n1,int n2)
    {
        if(root==null){
            return null;
        }

        if(root.data==n1 || root.data==n2){
            return root;
        }

        Node lnode= LCA(root.left,n1,n2);
        Node rnode= LCA(root.right,n1,n2);

        if(lnode!=null && rnode!=null){
            return root;
        }
        if(lnode==null){
            return rnode;
        }else{
            return lnode;
        }
    }
}