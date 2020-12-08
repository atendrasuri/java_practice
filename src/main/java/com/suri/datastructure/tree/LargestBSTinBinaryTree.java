package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 18/04/19
 * @Description: (Overwrite)
 * Given a binary tree, find size of largest binary search subtree in this
 *  * binary tree.
 *  *
 *  * Traverse tree in post order fashion. Left and right nodes return 4 piece
 *  * of information to root which isBST, size of max BST, min and max in those
 *  * subtree.
 *  * If both left and right subtree are BST and this node data is greater than max
 *  * of left and less than min of right then it returns to above level left size +
 *  * right size + 1 and new min will be min of left side and new max will be max of
 *  * right side.
 *  *
 *  * References:
 *  * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 *  * https://leetcode.com/problems/largest-bst-subtree/
 */
public class LargestBSTinBinaryTree {
    public static void main(String[] args) {

        LargestBST largestBST = new LargestBST();
        largestBST.createTree();
        largestBST.inOrder(largestBST.root);
        System.out.println();
        System.out.println("" + largestBST.largestBST(largestBST.root));

    }
}

class LargestBST {

    class MinMax {

        int min;
        int max;
        boolean isBST;
        int size;

        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
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

    LargestBST() {
        root = null;
    }

    public int largestBST(Node root) {
        MinMax m = largestBSTInBinaryTree(root);
        return m.size;
    }

    public void createTree() {
        this.root = new Node(25);

        Node n1 = new Node(18);
        Node n2 = new Node(50);

        Node n3 = new Node(19);
        Node n4 = new Node(20);
        Node n5 = new Node(35);
        Node n6 = new Node(60);


        Node n7 = new Node(15);
        Node n8 = new Node(18);
        Node n9 = new Node(25);
        Node n10 = new Node(20);
        Node n11 = new Node(40);
        Node n12 = new Node(55);
        Node n13 = new Node(70);

        Node n14 = new Node(25);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n3.right= n7;

        n4.left=n8;
        n4.right=n9;

        n5.left=n10;
        n5.right=n11;

        n6.left=n12;
        n6.right=n13;

        n10.right=n14;

    }

    public void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);

    }

    public MinMax largestBSTInBinaryTree(Node root) {

        if (root == null) {
            return new MinMax();
        }

        MinMax left = largestBSTInBinaryTree(root.left);
        MinMax right = largestBSTInBinaryTree(root.right);

        MinMax m = new MinMax();


        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST.
        //Return false and max size of left and right subtree to parent
        if (left.isBST == false || right.isBST == false || (left.max > root.data || right.min <= root.data)) {
            m.isBST = false;
            m.size = Math.max(left.size, right.size);
            return m;
        }


        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBST = true;
        m.size = left.size + right.size + 1;

        //if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = root.left == null ? root.data : left.min;

        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = root.right == null ? root.data : right.max;

        return m;


    }
}