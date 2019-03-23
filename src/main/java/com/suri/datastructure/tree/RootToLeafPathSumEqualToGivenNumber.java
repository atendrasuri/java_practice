package com.suri.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * Root to leaf path sum equal to a given number in Binary Tree.
 * @History:
 */
public class RootToLeafPathSumEqualToGivenNumber {

    public static void main(String[] args) {

        BSTRootToLeafSum bst = new BSTRootToLeafSum();

        bst.insertNode(6);bst.insertNode(13);bst.insertNode(16);bst.insertNode(20);bst.insertNode(21);bst.insertNode(15);
        bst.insertNode(5);bst.insertNode(14);bst.insertNode(8);bst.insertNode(9);

        bst.findPath();


    }

}

class BSTRootToLeafSum{

    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    Node root;

    BSTRootToLeafSum(){
       root=null;
    }

    public void insertNode(int data){
        root= insert(root, data);
    }

    public void findPath(){

        List<Integer> list = new ArrayList<>();
        if(isSumRootToLeaf(root,64,list )){
            for(Integer i:list){
                System.out.print(i+" ");
            }
        }
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


    public boolean isSumRootToLeaf(Node root, int sum, List<Integer> list) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (root.data == sum) {
                list.add(root.data);
                return true;
            } else {
                return false;
            }
        }
        if (isSumRootToLeaf(root.left, sum - root.data, list)) {

            list.add(root.data);
            return true;
        }
        if (isSumRootToLeaf(root.right, sum - root.data, list)) {
            list.add(root.data);
            return true;
        }
        return false;
    }

}