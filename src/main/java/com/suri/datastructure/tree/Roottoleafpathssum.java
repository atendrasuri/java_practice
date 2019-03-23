package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 23/03/19
 * @Description: (Overwrite)
 * Given a binary tree, where every node value is a number. Find the sum of all the numbers which are formed from root to leaf paths.
 *
 * For example consider the following Binary Tree.
 *
 *            6
 *          /   \
 *         3     7
 *       /   \     \
 *      2    5      8
 *         /
 *        4
 *
 *   There are 4 leaves, hence 4 root to leaf paths:
 *   Path                      Number
 *   6->3->2                   600+30+2=632
 *   6->3->5->4                6000+300+50+4=6354
 *   6->7->8                    600+70+8=678
 * Answer = 632 + 6354  + 678 = 7664
 * @History:
 */
public class Roottoleafpathssum{

    public static void main(String[] args) {

        RootToLeafPathsSumT bt = new RootToLeafPathsSumT();

        bt.insert(6);bt.insert(3);bt.insert(2);bt.insert(5);bt.insert(4);bt.insert(7);bt.insert(8);

        System.out.println(bt.rootToLeafSum(bt.root,0));

    }
}

class RootToLeafPathsSumT{


    class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

          Node root;
            RootToLeafPathsSumT(){
                root=null;
            }

            public void insert(int data){
                root= insert(root,data);
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

    public void inOrder(Node root){
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }


    public int rootToLeafSum(Node root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 10 + root.data;

        if (root.left == null && root.right == null) {
            return val;
        }
        return rootToLeafSum(root.left, val) + rootToLeafSum(root.right, val);
    }

}