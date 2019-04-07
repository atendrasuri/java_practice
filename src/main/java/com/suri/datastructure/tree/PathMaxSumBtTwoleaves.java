package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/03/19
 * @Description: (Overwrite)
 * Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * @History:
 */
public class PathMaxSumBtTwoleaves {
    public static void main(String[] args) {
        PathMaxSumLeaves tree= new PathMaxSumLeaves();

        tree.root = tree.new Node(-15);
        tree.root.left = tree.new Node(5);
        tree.root.right = tree.new Node(6);
        tree.root.left.left = tree.new Node(-8);
        tree.root.left.right = tree.new Node(1);
        tree.root.left.left.left = tree.new Node(2);
        tree.root.left.left.right = tree. new Node(6);
        tree.root.right.left = tree.new Node(3);
        tree.root.right.right = tree.new Node(9);
        tree.root.right.right.right = tree.new Node(0);
        tree.root.right.right.right.left = tree.new Node(4);
        tree.root.right.right.right.right = tree.new Node(-1);
        tree.root.right.right.right.right.left = tree.new Node(10);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxSumBetweenLeaf(tree.root));
    }
}

class PathMaxSumLeaves {

    int max = Integer.MIN_VALUE;
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    PathMaxSumLeaves() {
        root = null;
    }

    public void insertNode(int data) {
        root = insert(root, data);
    }


    public Node insert(Node node, int data) {

        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data > node.data) {
            node.right = insert(node.right, data);
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        }
        return node;

    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }


    public int maxSumBetweenLeaf(Node root) {

        maxPathSumUtil(root);
        return max;
    }

    public int maxPathSumUtil(Node root) {
        if (root == null) {
            return 0;
        }

        int ls= Math.max(0,maxPathSumUtil(root.left));
        int rs= Math.max(0,maxPathSumUtil(root.right));

        max= Math.max(max,ls+rs+root.data);

        return Math.max(ls,rs)+root.data;
    }


}