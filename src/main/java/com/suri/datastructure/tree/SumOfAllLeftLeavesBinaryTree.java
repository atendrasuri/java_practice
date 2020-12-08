package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SumOfAllLeftLeavesBinaryTree {
    public static void main(String[] args) {

        LeftLeavesBinaryTre leftLeavesBinaryTre = new LeftLeavesBinaryTre();

        leftLeavesBinaryTre.createTree();
        leftLeavesBinaryTre.display();

        int sum[] = new int[1];
        leftLeavesBinaryTre.sumOfAllLeavesNodes(leftLeavesBinaryTre.root,sum);

        System.out.println();
        System.out.println(" "+sum[0]);

    }
}


class LeftLeavesBinaryTre{

    class Node{

        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    Node root;

    LeftLeavesBinaryTre(){
        root=null;
    }



    public void display(){
        inOrder(root);
    }


    public void createTree()
    {
        this.root = new Node(0);

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        root.left  = n1;
        root.right = n2;

        n1.left  =  n4;
        n1.right = n5;

        n2.left  = n3;
        n2.right = n6;

        n5.left = n7;
    }

    public void inOrder(Node root){

        if(root==null){
            return;
        }

        inOrder(root.left);
        System.out.print(" "+root.data);
        inOrder(root.right);

    }

    public boolean isLeafNode(Node root){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }

    public void sumOfAllLeavesNodes(Node root, int sum[]){

        if(root==null){
            return;
        }

        if(isLeafNode(root.left)){
            sum[0]+= root.left.data;
        }
        sumOfAllLeavesNodes(root.left,sum);
        sumOfAllLeavesNodes(root.right,sum);

    }

}