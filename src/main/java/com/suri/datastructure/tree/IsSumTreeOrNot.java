package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/04/19
 * @Description: (Overwrite)
 * Write a function that returns true if the given Binary Tree is SumTree else false.
 * A SumTree is a Binary Tree where value of every node x is equal to sum of nodes present in its left subtree and right subtree of x.
 * An empty tree is SumTree and sum of an empty tree can be considered as 0.
 * A leaf node is also considered as SumTree.
 *
 * Following is an example of SumTree.
 *
 *           26
 *         /    \
 *       10      3
 *     /   \   /   \
 *    4     6  1    2
 * @History:
 */
public class IsSumTreeOrNot {

    public static void main(String[] args) {

        SumBinaryTree sumBinaryTree = new SumBinaryTree();
        sumBinaryTree.createTree();
        sumBinaryTree.display();

        System.out.println(sumBinaryTree.isSumTree(sumBinaryTree.root));
    }
}


class SumBinaryTree{

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    SumBinaryTree() {
        root = null;
    }

    public void display(){
        inOrder(root);
    }



    public void createTree() {
        this.root = new Node(26);

        Node n1 = new Node(10);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(4);
        Node n5 = new Node(6);
        Node n6 = new Node(2);
        //Node n7 = new Node(7);

        root.left = n1;
        root.right = n2;

        n1.left = n4;
        n1.right = n5;

        n2.left = n3;
        n2.right = n6;

    }


    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }


    boolean isSumTree(Node root)
    {

        if(root==null){
            return true;
        }
        if((root.left==null) &&(root.right==null)){
            return true;
        }

        int ls= sum(root.left);
        int rs= sum(root.right);

        if((root.data==ls+rs) && isSumTree(root.left)&& isSumTree(root.right)){
            return true;
        }

        return false;
    }

    public int sum(Node root){
        if(root==null){
            return 0;
        }

        int ls= sum(root.left);
        int rs= sum(root.right);
        return ls+rs+root.data;
    }

}