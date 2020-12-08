package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/06/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        DiameterBinaryTree diameterBinaryTree = new DiameterBinaryTree();

        diameterBinaryTree.createTree();

        System.out.println(diameterBinaryTree.findDiameter(diameterBinaryTree.root));

        System.out.println(diameterBinaryTree.findDiameter1(diameterBinaryTree.root).d);
        System.out.println(diameterBinaryTree.findDiameter1(diameterBinaryTree.root).h);


    }
}

class DiameterBinaryTree {

    class Pair{

        int h;
        int d;
    }

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

    }

    Node root;


    DiameterBinaryTree() {
        root = null;
    }

    public void createTree() {
        this.root = new Node(0);

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        root.left = n1;
        root.right = n2;

        n1.left = n4;
        n1.right = n5;

        n2.left = n3;
        n2.right = n6;

        n5.left = n7;
    }

    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }

    /**
     * approach one
     */

    public int findDiameter(Node root) {

        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        int lDiameter = findDiameter(root.left);

        int rDiameter = findDiameter(root.right);

        return Math.max(lheight + rheight, Math.max(lDiameter, rDiameter));

    }

    /**
     *
     * approach two
     */

    public Pair findDiameter1(Node root){

        if(root==null){
           Pair output= new Pair();
            output.h=0;
            output.d=0;
           return output;
        }

        Pair lo= findDiameter1(root.left);

        Pair ro= findDiameter1(root.right);

        int height= 1+Math.max(lo.h,ro.h);

        /**
         * option1 = doing sum of heights
         */
        int option1= lo.h+ro.h;
        /**
         * option2 finding diameter in left sub tree
         */
        int option2= lo.d;

        /**
         * option3 finding diameter in right sub tree
         */
        int option3= ro.d;

        int diameter = Math.max(option1,Math.max(option2,option3));


        Pair output= new Pair();

        output.h=height;
        output.d=diameter;
        return output;




    }


    public int height(Node root) {

        if (root == null) {
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l, r) + 1;
    }
}