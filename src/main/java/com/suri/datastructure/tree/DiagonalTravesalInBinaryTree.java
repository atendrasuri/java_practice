package com.suri.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DiagonalTravesalInBinaryTree {


    public static void main(String[] args) {


        DTraversalBinaryTree dTraversalBinaryTree = new DTraversalBinaryTree();

        dTraversalBinaryTree.createTree();
        dTraversalBinaryTree.display();
        System.out.println();
        dTraversalBinaryTree.diagonalPrint();
    }
}


class DTraversalBinaryTree{


    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    Node root;

    DTraversalBinaryTree(){
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

    public void diagonalPrint()
    {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        diagonalTraversal(root,map,0);

        for(Integer hd:map.keySet()){
            List<Integer> elements=map.get(hd);

            for(Integer element:elements ){
                System.out.print(element+" ");
            }
        }
    }

    public void diagonalTraversal(Node root, HashMap<Integer,List<Integer>> map, int hd){

        if(root==null){
            return;
        }

        diagonalTraversal(root.left,map,hd+1);
        List<Integer> oldElements=new ArrayList<>();
        if(map.get(hd)!=null){
            oldElements = map.get(hd);
        }
        oldElements.add(root.data);
        map.put(hd,oldElements);

        diagonalTraversal(root.right,map,hd);

    }
}