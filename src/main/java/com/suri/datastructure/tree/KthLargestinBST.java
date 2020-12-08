package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 *
 * Hint:- do the reverse inorder traversal
 * @History:
 */
public class KthLargestinBST {

    public static void main(String[] args) {

        KthLargestBST kthLargestBST = new KthLargestBST();
        kthLargestBST.createTree();
        kthLargestBST.display();
        System.out.println();
        kthLargestBST.kthLargest(kthLargestBST.root, 3);


    }
}

class KthLargestBST {
    class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    KthLargestBST() {
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

    public void kthLargest(Node root, int k) {
        int count[] = new int[1];
        Node temp = kthLargestNode(root, k, count);
        System.out.print(temp.data + " ");
    }

    public Node kthLargestNode(Node root, int k, int count[]) {
        if (root == null) {
            return null;
        }

        Node nthLargest = kthLargestNode(root.right, k, count);

        if (nthLargest == null) {

            count[0] += 1;

            if (count[0] == k) {
                nthLargest = root;
            }
        }

        if (nthLargest == null) {
            nthLargest = kthLargestNode(root.left, k, count);
        }

        return nthLargest;
    }

}