package com.suri.datastructure.tree;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PathWithGivenSum {

    public static void main(String[] args) {

        BSTPath bst = new BSTPath();

        bst.insertNode(6);bst.insertNode(13);bst.insertNode(16);bst.insertNode(20);bst.insertNode(21);bst.insertNode(15);
        bst.insertNode(5);bst.insertNode(14);bst.insertNode(8);bst.insertNode(9);

        bst.display();
        bst.findPath();

    }
}


class BSTPath{

    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data= data;
        }
    }

    Node root;
    String path;

    BSTPath(){
        root=null;
    }

    public void insertNode(int data){
        root= insert(root, data);
    }

    public void display(){

      //  inOrder(root);
    }

    public void findPath(){
        //hasPath(root,36,path);
        Stack<Integer> stack = new Stack<>();
        hasPath(root,stack, 36,0 );
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


    /**
     * using stack
     */


    public void hasPath(Node root, Stack<Integer> stack, int k, int sum){


        if(root==null){
            return;
        }

        sum= sum+root.data;
        stack.push(root.data);

        if(sum==k){
            while(stack.size()>0){
                System.out.print(stack.pop()+" ");
            }
        }

        hasPath(root.left, stack,k, sum);
        hasPath(root.right, stack,k, sum);

        sum= sum-root.data;
        if(!stack.isEmpty()){
        stack.pop();}

    }
}