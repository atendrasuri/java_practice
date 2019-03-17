package com.suri.GSCoderpad;/* Problem Name is &&& Search Tree &&& PLEASE DO NOT REMOVE THIS LINE. */


//import org.junit.Test;
//import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static org.junit.Assert.*;

/*
 Instructions to candidate.
  1) Run this code in the REPL to observe its behaviour. The
   execution entry point is main().
  2) Implement the "put" and "contains" methods.
  3) Fix the "inOrderTraversal" method.
  4) Add additional relevant tests
  5) If time permits, try to improve your implementation.
*/

public class SearchTree {

  static class BST  {

    private Node root;

    public BST() {
      this.root = null;
    }

    public void put(int value) {
     root= insert(root,value);
    }

    public Node insert(Node root, int data){
      if(root==null){
        Node temp= new Node();
        temp.val= data;
        temp.left=temp.right=null;
        root=temp;
        return root;
      }
      if(data<root.val){
        root.left= insert(root.left, data);
      }
      else if(data>root.val){
        root.right= insert(root.right, data);
      }
      return root;
    }

    public boolean contains(int value) {

      return serach(root,value);
    }

    public boolean serach(Node root, int value){
      if(root!=null){
        if(root.val==value){
          return true;
        }
        if(value<root.val){
          return serach(root.left,value);
        }else if(value>root.val){
          return serach(root.right,value);
        }
      }
      return false;
    }

    public List<Integer> inOrderTraversal() {
      final ArrayList<Integer> acc = new ArrayList<>();
      inOrderTraversal(root, acc);
      return acc;
    }

    private void inOrderTraversal(Node node, List<Integer> acc) {
      if (node == null) {
        return;
      }
      inOrderTraversal(node.left, acc);
      System.out.print(node.val+" ");
      acc.add(node.val);
      inOrderTraversal(node.right, acc);

    }

    private static class Node {
      Integer val;
      Node left;
      Node right;
      /*Node(int data){
        val=data;
        left=right=null;
      }*/
    }
  }



  public void testBST() throws Exception {
    final BST searchTree = new BST();
    searchTree.inOrderTraversal();

    searchTree.put(3);
    searchTree.put(1);
    searchTree.put(2);
    searchTree.put(5);

    System.out.println(searchTree.contains(0));
    System.out.println(searchTree.contains(1));
    System.out.println(searchTree.contains(2));
    System.out.println(searchTree.contains(3));
    System.out.println(searchTree.contains(4));
    System.out.println(searchTree.contains(5));
    System.out.println(searchTree.contains(6));

    System.out.println( Arrays.asList(1,2,3,5).toString().equals(searchTree.inOrderTraversal()));
  }

  // TODO: write some more tests

  public static void main(String[] args) throws Exception {
    SearchTree obj = new SearchTree();
    obj.testBST();

  }

}