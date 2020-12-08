package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
 *
 * Consider the below trees:
 * (a) and (b) can be folded.
 * (c) and (d) cannot be folded.
 *
 * (a)
 *        10
 *      /    \
 *     7      15
 *      \    /
 *       9  11
 * (b)
 *         10
 *        /  \
 *       7    15
 *      /      \
 *     9       11
 * (c)
 *         10
 *        /  \
 *       7   15
 *      /    /
 *     5   11
 * (d)
 *          10
 *        /   \
 *       7     15
 *     /  \    /
 *    9   10  12
 */
public class FoldableBinaryTree {
  public static void main(String[] args) {

    FoldableBT foldableBT = new FoldableBT();

    foldableBT.createTree();
    foldableBT.display();
    System.out.println();
    System.out.println(foldableBT.isFoldable(foldableBT.root));

  }
}

class FoldableBT {
  class Node {

    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  Node root;

  FoldableBT() {
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

  public boolean isFoldable(Node root) {
    if (root == null) {
      return true;
    }
    return checkFoldable(root.left, root.right);

  }

  public boolean checkFoldable(Node root1, Node root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    return checkFoldable(root1.left, root2.right) && checkFoldable(root1.right, root2.left);
  }

}