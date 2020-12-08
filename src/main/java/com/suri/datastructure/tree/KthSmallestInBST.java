package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class KthSmallestInBST {
    public static void main(String[] args) {
        KthSmallestBST kthSmallestBST= new KthSmallestBST();
        kthSmallestBST.createTree();
        kthSmallestBST.display();
        System.out.println();
        kthSmallestBST.kthSmallest(kthSmallestBST.root,4);
    }
}

class KthSmallestBST {
    class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    KthSmallestBST() {
        root = null;
    }


    public void display() {
        inOrder(root);
    }


    public void createTree() {
        this.root = new Node(6);

        Node n1 = new Node(4);
        Node n2 = new Node(8);

        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(7);
        Node n7 = new Node(9);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n5;

        n2.left = n6;
        n2.right = n7;


    }

    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }

    public void kthSmallest(Node root, int k) {
        int count[] = new int[1];
        Node temp = kthSmallestNode(root, k, count);
        System.out.print(temp.data + " ");
    }


    public static Node kthSmallestNode(Node root,int k, int sum[]){

        if(root==null){
            return null;
        }

        Node kthSamallest= kthSmallestNode(root.left,k,sum);

        if(kthSamallest==null){
            sum[0]+= 1;

            if(sum[0]==k){
                kthSamallest= root;
            }
        }

        if(kthSamallest==null){
            kthSamallest=kthSmallestNode(root.right,k,sum) ;
        }
        return kthSamallest;
    }
}