package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 10/04/19
 * @Description: (Overwrite)
Given a Binary Tree you need to find maximum value which you can get by subtracting value of node B from value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B.
You are required to complete the function maxDiff.
You should not read any input from stdin/console. T
here are multiple test cases. For each test case, this method will be called individually.
 * @History:
 */
public class MaxDifferenceNodeAncestor {
    public static void main(String[] args) {

        MaxDiffBinaryTree maxDiffBinaryTree = new MaxDiffBinaryTree();
        maxDiffBinaryTree.createTree();
        maxDiffBinaryTree.display();
        System.out.println();
        System.out.println(maxDiffBinaryTree.maxDiff(maxDiffBinaryTree.root));
    }
}

class MaxDiffBinaryTree{

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    MaxDiffBinaryTree() {
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


    int maxDiff(Node root)
    {
        return maxDifference(root, -1);
    }

   int maxDifference(Node node, int maxParent) {
        if(node == null) {
            return -1;
        }
        int diffAtNode = maxParent - node.data;
        int maxForChildren = Math.max(maxParent, node.data);
        int diffAtLeft = maxDifference(node.left, maxForChildren);
        int diffAtRight = maxDifference(node.right, maxForChildren);

        return Math.max(diffAtNode, Math.max(diffAtLeft, diffAtRight));
    }
}