package com.suri.datastructure.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/04/19
 * @Description: (Overwrite)
 *Given below is a tree. The task is to print the Reverse Level Order Traversal of the given tree
 * @History:
 */
public class PrintReverseLevelOrderBinaryTree {

    public static void main(String[] args) {

        ReverseLevelbinaryTree reverseLevelbinaryTree= new ReverseLevelbinaryTree();

        reverseLevelbinaryTree.createTree();
        reverseLevelbinaryTree.inOrder(reverseLevelbinaryTree.root);
        System.out.println();
        reverseLevelbinaryTree.reversePrint(reverseLevelbinaryTree.root);
    }
}


class ReverseLevelbinaryTree{
    class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;


    ReverseLevelbinaryTree(){
        root=null;
    }
    public void createTree()
    {
        this.root = new Node(1);

        Node n1 = new Node(2);
        Node n2 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        root.left  = n1;
        root.right = n2;

        n1.left  =  n4;
        n1.right = n5;

        n2.left  = n6;
        n2.right = n7;


    }

    public void inOrder(Node root){

        if(root==null){
            return;
        }

        inOrder(root.left);
        System.out.print(" "+root.data);
        inOrder(root.right);

    }

    void reversePrint(Node root)
    {
        if(root==null){
            return;
        }

        LinkedList<Node> queue= new LinkedList<>();

        Stack<Node> stack= new Stack<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node temp= queue.remove();
            stack.push(temp);
            if(temp.right!=null){
                queue.add(temp.right);
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }

        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().data+" ");
        }

    }
}