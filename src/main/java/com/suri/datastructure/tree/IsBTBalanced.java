package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given a binary tree, find if it is height balanced or not.
 * A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree.
 *
 * A height balanced tree
 *         1
 *      /     \
 *    10      39
 *   /
 * 5
 *
 * An unbalanced tree
 *         1
 *      /
 *    10
 *   /
 * 5
 */
public class IsBTBalanced {
  public static void main(String[] args) {

    BalancedTree balancedTree = new BalancedTree();
    balancedTree.createTree();
    System.out.println();
    balancedTree.display();
    System.out.println();
    System.out.println(balancedTree.isBalanced(balancedTree.root));

  }
}

class BalancedTree {

  class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }


  Node root;

  BalancedTree() {
    root = null;
  }

  public void display() {
    inOrder(root);
  }


  public void createTree() {

    this.root = new Node(10);

    Node n1 = new Node(20);
    Node n2 = new Node(30);
   // Node n3 = new Node(1);
    Node n4 = new Node(40);
    Node n5 = new Node(60);
    //Node n6 = new Node(2);
    //Node n7 = new Node(7);

    root.left = n1;
    root.right = n2;

    n1.left = n4;
    n1.right = n5;

    /*n2.left = n3;
    n2.right = n6;*/

  }


  public void inOrder(Node root) {

    if (root == null) {
      return;
    }

    inOrder(root.left);
    System.out.print(" " + root.data);
    inOrder(root.right);

  }

  boolean isBalanced(Node root)
  {
    if(checkBalanced(root)==-1){
      return false;
    }else{
      return true;
    }
  }
  int checkBalanced(Node root){
    if(root==null){
      return 0;
    }

    int leftHeight = checkBalanced(root.left);
    if(leftHeight==-1){
      return -1;
    }
    int rightHeight = checkBalanced(root.right);
    if(rightHeight==-1){
      return -1;
    }
    if(Math.abs(leftHeight-rightHeight)>1){
      return -1;
    }
    return 1+Math.max(leftHeight,rightHeight);
  }

  /* This function should return tree if passed  tree
     is balanced, else false. */
  boolean isBalanced1(Node root)
  {
    if(root==null){
      return true;
    }

    int l = height(root.left);
    int r = height(root.right);

    if(Math.abs(l-r)<=1 && isBalanced1(root.left) && isBalanced1(root.right) ){
      return true;
    }
    return false;
  }

  public int height(Node root){
    if(root==null){
      return 0;
    }
    return 1+Math.max(height(root.left),height(root.right));
  }
}