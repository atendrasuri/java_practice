package com.suri.datastructure.tree;

import java.util.LinkedHashMap;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/11/18
 * @Description: (Overwrite)
 * Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different vertical lines.
 * Examples:
 *
 *       1
 *     /   \
 *   2      3
 *  / \    / \
 * 4   5  6   7
 * The tree has 5 vertical lines
 *
 * Vertical-Line-1 has only one node 4 => vertical sum is 4
 * Vertical-Line-2: has only one node 2=> vertical sum is 2
 * Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
 * Vertical-Line-4: has only one node 3 => vertical sum is 3
 * Vertical-Line-5: has only one node 7 => vertical sum is 7
 *
 * So expected output is 4, 2, 12, 3 and 7
 */
public class VerticalSumInBT {

    public static void main(String[] args) {

        VerticalSumBinaryTree bst = new VerticalSumBinaryTree();
        bst.createBST(100);
        bst.createBST(2);
        bst.createBST(3);
        bst.createBST(14);
        bst.createBST(50);
        bst.createBST(6);
        bst.createBST(7);
        bst.createBST(80);
        bst.createBST(9);
        bst.createBST(10);
        /*bst.displayInorder();*/


        System.out.println();

        //bst.displayInorder();
        bst.printverticalSum();

    }
}


class VerticalSumBinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

    }

    Node root;

    VerticalSumBinaryTree() {

        root = null;
    }

    /*
      utility methods
     */

    public void createBST(int data) {
        root = insert(root, data);
    }

    public void displayInorder() {
        inOrder(root);
    }


    public void printverticalSum(){
        LinkedHashMap<Integer,Integer> map= new LinkedHashMap();

        verticalSum(root,0,map);

        for(Integer key:map.keySet()){
            System.out.println(map.get(key)+" ");
        }
        System.out.println();
    }




    public Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data > node.data) {
            node.right = insert(node.right, data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        }
        return node;
    }


    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print("  " + node.data);
            inOrder(node.right);
        }
    }



    public void verticalSum(Node root, int hd, LinkedHashMap<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        verticalSum(root.left, hd - 1, map);

        int oldSum = map.get(hd) == null ? 0 : map.get(hd);
        map.put(hd, oldSum + root.data);
        verticalSum(root.right, hd + 1, map);

    }


}