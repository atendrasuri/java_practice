package com.suri.datastructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DiagonalSumInBinaryTree {

    public static void main(String[] args) {

        DSumBinaryTree dSumBinaryTree = new DSumBinaryTree();

        dSumBinaryTree.createTree();
        dSumBinaryTree.display();
        System.out.println();
        dSumBinaryTree.displayDiagonalSum();

    }
}




class DSumBinaryTree{


    class Node{

        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

  Node root;

    DSumBinaryTree(){
        root=null;
    }



    public void display(){
        inOrder(root);
    }

    public void displayDiagonalSum(){

        HashMap<Integer,Integer>diagSum= new HashMap<>();

        findDiagonalSum(root,0,diagSum);

        for(Map.Entry<Integer,Integer> m:diagSum.entrySet()){

            System.out.println(m.getKey()+"  "+m.getValue());
        }
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



    public void findDiagonalSum(Node root, int currDiag, HashMap<Integer,Integer>diagSum){



        if(root==null){
            return;
        }

        findDiagonalSum(root.left,currDiag+1,diagSum);

        int prevSum=0;

        if(diagSum.get(currDiag)!=null){
            prevSum= diagSum.get(currDiag);
        }
        diagSum.put(currDiag,prevSum+root.data);

        findDiagonalSum(root.right,currDiag,diagSum);
    }

}