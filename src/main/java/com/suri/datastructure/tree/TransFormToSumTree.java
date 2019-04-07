package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/04/19
 * @Description: (Overwrite)
 * Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.
 *
 * For example, the following tree
 *
 *              10
 *           /      \
 *         -2        6
 *        /   \     /  \
 *      8     -4   7    5
 *
 * should be changed to
 *
 *        20(4-2+12+6)
 *           /              \
 *      4(8-4)      12(7+5)
 *        /   \           /  \
 *      0      0       0    0
 * @History:
 */
public class TransFormToSumTree {

    public static void main(String[] args) {

        TransformSumTree transformSumTree = new TransformSumTree();
        transformSumTree.createTree();
        transformSumTree.display();
        transformSumTree.toSumTree();

        System.out.println();
        transformSumTree.display();

    }
}


class TransformSumTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    TransformSumTree() {
        root = null;
    }

    public void display(){
        inOrder(root);
    }

    public void toSumTree(){

        transformToSumTree(root);
    }

    public void createTree() {
        this.root = new Node(10);

        Node n1 = new Node(-2);
        Node n2 = new Node(6);
        Node n3 = new Node(7);
        Node n4 = new Node(8);
        Node n5 = new Node(-4);
        Node n6 = new Node(5);
        //Node n7 = new Node(7);

        root.left = n1;
        root.right = n2;

        n1.left = n4;
        n1.right = n5;

        n2.left = n3;
        n2.right = n6;

    }


    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }


    public int transformToSumTree(Node root){

        if(root==null){
            return 0;
        }

        int left=transformToSumTree(root.left);

        int right= transformToSumTree(root.right);

        int oldVal= root.data;

        root.data=left+right;

        return oldVal+root.data;
    }

}