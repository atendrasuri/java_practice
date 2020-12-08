package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a Binary Tree of size N, your task is to complete the function isSymettric(), that check whether a binary is Symmetric or not, i.e. the binary tree is Mirror image of itself or not.
 * For example:
 * The following binary tree is symmetric:
 * <p>
 * 1
 * /   \
 * 2       2
 * /   \   /   \
 * 3     4 4     3
 * <p>
 * But the following is not:
 * <p>
 * 1
 * /   \
 * 2      2
 * \      \
 * 3      3
 */
public class SymmetricTree {
  public static void main(String[] args) {

    BinaryMirrorTree binaryMirrorTree = new BinaryMirrorTree();

    binaryMirrorTree.createTree();
    binaryMirrorTree.display();
    System.out.println();
    System.out.println(binaryMirrorTree.isSymmetric(binaryMirrorTree.root));

  }
}

class BinaryMirrorTree {

  class Node {

    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  Node root;

  BinaryMirrorTree() {
    root = null;
  }


  public void display() {
    inOrder(root);
  }


  public void createTree() {
    this.root = new Node(0);

    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);

    root.left = n1;
    root.right = n2;

    n1.left = n4;
    n1.right = n5;

    n2.left = n3;
    n2.right = n6;

    n5.left = n7;
  }

  public void inOrder(Node root) {

    if (root == null) {
      return;
    }

    inOrder(root.left);
    System.out.print(" " + root.data);
    inOrder(root.right);

  }

  public boolean isSymmetric(Node root) {
    return isMirror(root, root);
  }

  public boolean isMirror(Node root1, Node root2) {

    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 != null && root2 != null && (root1.data == root2.data)) {

      return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
    return false;
  }
}