package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/04/19
 * @Description: (Overwrite)
 * Given a binary tree, write a function that returns true if the tree satisfies the following property:
 * For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.
 * Also, leaves are considered to follow the property.
 * @History:
 */
public class ChildrenSumParent {
    public static void main(String[] args) {

        ChildrenSumParentBinaryTree childrenSumParentBinaryTree = new ChildrenSumParentBinaryTree();
        childrenSumParentBinaryTree.createTree();
        childrenSumParentBinaryTree.display();

        System.out.println(childrenSumParentBinaryTree.isSumProperty(childrenSumParentBinaryTree.root));

    }
}

class ChildrenSumParentBinaryTree{

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    Node root;

    ChildrenSumParentBinaryTree() {
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


    public int isSumProperty(Node root){

        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return 1;
        }

        else if(root.left.data+root.right.data==root.data){
            return 1;
        }
        isSumProperty(root.left);
        isSumProperty(root.right);


        return 0;
    }



}