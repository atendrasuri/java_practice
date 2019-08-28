package com.suri.datastructure.tree;

import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class MaxPathSumBinaryTree {
  public static void main(String[] args) {
    PathMaxSum pathMaxSum = new PathMaxSum();
    pathMaxSum.createTree();
    pathMaxSum.display();
    System.out.println();
    pathMaxSum.findMaxSumPath(pathMaxSum.root);
    System.out.println(pathMaxSum.maximumSum);


  }


}

class PathMaxSum {

  int max = Integer.MIN_VALUE;

  class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }


  Node root;

  int maximumSum = Integer.MIN_VALUE;

  PathMaxSum() {
    root = null;
  }

  public void display() {
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


  public int findMaxSumPath(Node root) {

    if (root == null) {
      return 0;
    }

    int l = findMaxSumPath(root.left);
    int r = findMaxSumPath(root.right);

    int maxLR = Math.max(l, r);
    int maxSingle = Math.max(maxLR + root.data, root.data);

    int maxAll = Math.max(maxSingle, l + r + root.data);

    maximumSum = Math.max(maximumSum, maxAll);
    return maxSingle;
  }

}