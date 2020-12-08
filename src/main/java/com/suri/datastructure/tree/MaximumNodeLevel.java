package com.suri.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/04/19
 * @Description: (Overwrite)
 * Find the level in a binary tree which has the maximum number of nodes. The root is at level 0.
 * @History:
 */
public class MaximumNodeLevel {
    public static void main(String[] args) {

        MaximumNodeLevelTree maximumNodeLevelTree= new MaximumNodeLevelTree();
        maximumNodeLevelTree.createTree();
        maximumNodeLevelTree.display();
        System.out.println();

        System.out.println(maximumNodeLevelTree.maxNodeLevel(maximumNodeLevelTree.root)+" ");

    }
}

class MaximumNodeLevelTree{

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    MaximumNodeLevelTree() {
        root = null;
    }

    public void display(){
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

    public int maxNodeLevel(Node root)
    {
        int level=0;
        int max=-1;
        int result=0;

        Queue<Node> queue= new LinkedList<>();
        if(root==null){
            return result;
        }
        queue.add(root);

        while(queue.size()>0){
            level++;
            int size= queue.size();
            if(size>max){
                max=size;
                result=level;
            }

            while(size>0){

                Node temp= queue.remove();

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                size--;
            }
        }

        return result-1;
    }
}