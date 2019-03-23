package com.suri.datastructure.tree;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DepthOfBT {

    public static void main(String[] args) {

        BST bst = new BST();
        bst.insertNode(20);
        bst.insertNode(8);
        bst.insertNode(22);
        bst.insertNode(4);
        bst.insertNode(12);
        bst.insertNode(10);
        bst.insertNode(14);
        int n1 = 10;
        int n2 = 14;
        //bst.root = bst.findLCA(bst.root, n1, n2);

        //System.out.println("LCA of " + n1 + " and " + n2 + " is " + bst.root.data);

        bst.display();

        /*System.out.println();
        System.out.println("printing left view of the tree:-");
        //bst.printLeftView();

        System.out.println();
        System.out.println("printing right view of the tree:-");
        bst.printRightView();

        System.out.println();
        System.out.println("printing level order traversal");
        bst.printLeveOrder();

        System.out.println();
        System.out.println("total no of node:- " + bst.totalNoNode());
        System.out.println("height of BST is :- " + bst.findHeight());

        //bst.findKthLargest(1);
        bst.findKthSmallest(1);*/
        bst.convertMirrorTree();

        System.out.println(" after mirror tree");
        bst.display();

    }
}


class BST {


    class Node {

        Node left;
        Node right;
        int data;

        Node(int _data) {
            data = _data;
            left = right = null;
        }

    }

    Node root;

    static int counter;
    static int max_level = 0;

    BST() {
        root = null;
    }

    public void insertNode(int data) {

        root = insert(root, data);
    }

    public void display() {

        inOrder(root);
    }

    public void printLeftView() {
        leftView(root, 1);
    }

    public void printRightView() {
        rightView(root, 1);
    }

    public void printLeveOrder(){
        levelOrderTraversal(root);
    }

    public int totalNoNode() {

        return countNode(root);
    }

    public int findHeight() {
        return heightofBST(root);
    }


    public void findKthLargest(int k) {

        Node node = kthLargestElement(root, k);

        System.out.println(node.data);
    }

    public void findKthSmallest(int k) {

        Node node = kthSmallestElement(root, k);

        System.out.println(node.data);
    }

    public void convertMirrorTree(){
        root = mirrorTree(root);
    }

    public Node insert(Node node, int data) {

        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);

        }

        return node;
    }


    public void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }

    }


    public int countNode(Node node) {
        if (node == null) {
            return 0;
        }

        return countNode(node.left) + countNode(node.right) + 1;


    }

    public int heightofBST(Node node) {

        if (node == null) {
            return 1;
        }

        int lheight = heightofBST(node.left);

        int rheight = heightofBST(node.right);

        return Math.max(lheight, rheight) + 1;
    }

    public Node kthLargestElement(Node node, int k) {

        if (node == null) {
            return null;
        }


        Node node1 = kthLargestElement(node.right, k);

        if (counter != k) {
            counter++;
            node1 = node;
        }

        if (counter == k) {
            return node1;

        } else {
            return kthLargestElement(node.left, k);
        }


    }


    public Node kthSmallestElement(Node node, int k) {

        if (node == null) {
            return null;
        }


        Node node1 = kthSmallestElement(node.left, k);

        if (counter != k) {
            counter++;
            node1 = node;
        }

        if (counter == k) {
            return node1;

        } else {
            return kthSmallestElement(node.right, k);
        }
    }

    public Node findLCA(Node root, int n1, int n2) {

        while (root != null) {

            if (root.data > n1 && root.data > n2) {
                root = root.left;
            } else if (root.data < n1 && root.data < n2) {
                root = root.right;
            } else
                break;
        }
        return root;
    }

    public Node findLCARecursive(Node root, int n1, int n2) {

        if (root == null)
            return null;

        if (root.data > n1 && root.data > n2)
            return findLCARecursive(root.left, n1, n2);
        if (root.data < n1 && root.data < n2)
            return findLCARecursive(root.right, n1, n2);

        return root;

    }

    public void leftView(Node node, int level) {

        if (node == null) {
            return;
        }
        if (max_level < level) {
            System.out.print("  " + node.data);
            max_level = level;
        }

        leftView(node.left, level + 1);
        leftView(node.right, level + 1);
    }

    public void rightView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (max_level < level) {
            System.out.print("  " + node.data);
            max_level = level;
        }

        rightView(node.right, level + 1);
        rightView(node.left, level + 1);
    }

    public void levelOrderTraversal(Node node) {

        int h = heightofBST(node);

        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i);
        }
    }

    public void printGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print("  "+node.data);
        }

        printGivenLevel(node.left, level - 1);
        printGivenLevel(node.right, level - 1);

    }


    // Convert a binary tree to mirror tree

        public Node mirrorTree(Node node){

            if(node==null){
                return node;

            }
            Node left = mirrorTree(node.left);
            Node right = mirrorTree(node.right);

            node.left= right;
            node.right=left;

            return node;
        }


}