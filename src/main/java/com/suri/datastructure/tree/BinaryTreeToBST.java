package com.suri.datastructure.tree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 01/07/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class BinaryTreeToBST {

    public static void main(String[] args) {

        BinaryTreeBST binaryTreeBST = new BinaryTreeBST();
        binaryTreeBST.createTree();

        binaryTreeBST.inOrder(binaryTreeBST.root);
        System.out.println();
        binaryTreeBST.inOrder(binaryTreeBST.binaryTreeToBST(binaryTreeBST.root));

    }
}

class BinaryTreeBST {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;


    public void display() {
        inOrder(root);
    }


    public void createTree() {
        this.root = new Node(10);

        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n6 = new Node(60);


        root.left = n2;
        root.right = n3;

        n2.left = n4;
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

    public Node binaryTreeToBST(Node root) {
        if (root == null) {
            return null;
        }

        Set<Integer> set = new TreeSet<>();

        extractKeys(root, set);
        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);

        return root;
    }

    public void extractKeys(Node root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        extractKeys(root.left, set);
        set.add(root.data);
        extractKeys(root.right, set);
    }

    public void convertToBST(Node root, Iterator<Integer> it) {

        if (root == null) {
            return;
        }
        convertToBST(root.left, it);
        root.data = it.next();
        convertToBST(root.right, it);

    }
}