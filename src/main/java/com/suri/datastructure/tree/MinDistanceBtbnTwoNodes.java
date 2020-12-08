package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 10/04/19
 * @Description: (Overwrite)
 * Given a binary tree and two node values your task is to find the minimum distance between them.
 * @History:
 */
public class MinDistanceBtbnTwoNodes {

    public static void main(String[] args) {

        MinDistanceBinaryTree minDistanceBinaryTree = new MinDistanceBinaryTree();
        minDistanceBinaryTree.createTree();

        minDistanceBinaryTree.display();
        System.out.println();

        System.out.println(minDistanceBinaryTree.findDist(minDistanceBinaryTree.root, 2, 3));
    }
}


class MinDistanceBinaryTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    MinDistanceBinaryTree() {
        root = null;
    }

    public void display() {
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


    int findDist(Node root, int a, int b) {
        Node node = findLCA(root, a, b);

        int lh = findHeight(node, a, 0);
        int rh = findHeight(node, b, 0);

        return lh + rh;
    }

    Node findLCA(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.data == a || root.data == b) {
            return root;
        }
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    int findHeight(Node root, int a, int h) {
        if (root == null)
            return -1;

        if (root.data == a) {
            return h;
        }
        int lh = findHeight(root.left, a, h + 1);
        if (lh == -1)
            return findHeight(root.right, a, h + 1);

        return lh;
    }

}