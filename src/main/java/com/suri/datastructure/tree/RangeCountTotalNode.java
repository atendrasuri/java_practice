package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/03/19
 * @Description: (Overwrite)
 * Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.
 * @History:
 */
public class RangeCountTotalNode {
    public static void main(String[] args) {
        RangeCountBST bst = new RangeCountBST();
        bst.insertNode(10);bst.insertNode(5);bst.insertNode(50);bst.insertNode(1);bst.insertNode(40);bst.insertNode(100);

        //10 5 50 1 40 100

        System.out.println(bst.getCountOfNode(bst.root,5,45));

    }
}

class RangeCountBST{

    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data= data;
        }
    }

    Node root;

    public void insertNode(int data){
        root= insert(root,data);
    }

    public Node insert(Node node, int data){

        if(node==null){
            node= new Node(data);
            return node;
        }

        if(data>node.data){
            node.right= insert(node.right,data);
        }
        else if(data<node.data){
            node.left= insert(node.left,data);
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
    public  int getCountOfNode(Node root,int l, int h){

        if(root==null){
            return 0;
        }
        if(root.data>=l && root.data<=h){
            return 1+getCountOfNode(root.left,l,h)+getCountOfNode(root.right,l,h);
        }else if(root.data<l){
            return getCountOfNode(root.right,l,h);
        }else{
           return getCountOfNode(root.left,l,h);
        }
    }


}