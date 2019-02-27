package com.suri.bstPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class BSTPractice {

    public static void main(String[] args) {

        BST bst = new BST();

        bst.insertNode(6);bst.insertNode(13);bst.insertNode(16);bst.insertNode(20);bst.insertNode(21);bst.insertNode(15);
        bst.insertNode(5);bst.insertNode(14);bst.insertNode(8);bst.insertNode(9);


        bst.display();
        bst.findPath();

    }
}


class BST{

    class Node{

        int data;
        Node left,right;


        Node(int _data){
            data=_data;
            left=right=null;

        }
    }

    Node root;
    String path;

    BST(){
        root = null;
    }


    public void insertNode(int data){
        root = insert(root,data);
    }

    public void findPath(){
        hasPath(root,36,path);
    }

    public void display(){
        //inOrder(root);
       // inOrderWithoutRecurssion(root);
        //levelOrderTraversal(root);
        preOrderIterative(root);
    }


    public Node insert(Node node, int data){

        if(node==null){
            node= new Node(data);
            return node;
        }

        if(data>node.data){
            node.right= insert(node.right,data);
        }
        else if(data<node.data){
            node.left= insert(node.left,data);
        }
        return node;

    }

    public void inOrder(Node root){
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }



    public void inOrderWithoutRecurssion(Node root){

        if(root==null){
            System.out.println(" Tree is empty");
            return;
        }

        Node node=root;

        Stack<Node> st = new Stack<>();
        while( node!=null ||st.size()>0){

           while(node!=null){
               st.push(node);
               node=node.left;
           }

            node= st.pop();
            System.out.println(node.data+" ");

            node= node.right;


        }

    }


    public void levelOrderTraversal(Node root){


        if(root==null){
            System.out.println(" Tree is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            Node temp=queue.poll();

            System.out.print(temp.data + "  ");
            if(null!=temp.left){
                queue.add(temp.left);

            }
            if(null!=temp.right){
                queue.add(temp.right);
            }

        }
    }


    public void preOrderIterative(Node root) {

        if (root == null) {
            System.out.println(" Tree is empty");
            return;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {

            Node temp = st.pop();
            if (temp != null) {
                System.out.print(temp.data + " ");
            }
            if (null != temp.right) {
                st.push(temp.right);
            }
            if (null != temp.left) {
                st.push(temp.left);
            }
        }


    }


    public void hasPath(Node root, int sum, String path) {

        if (root != null) {

            if (root.data > sum) {
                return;
            } else {
                path+= " " + root.data;

                sum = sum - root.data;
                if (sum == 0) {
                    System.out.println(" path is" + path);
                }
                hasPath(root.left, sum, path);
                hasPath(root.right, sum, path);

            }
        }
    }

}