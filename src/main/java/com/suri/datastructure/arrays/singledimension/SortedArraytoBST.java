package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 01/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SortedArraytoBST {

    public static void main(String[] args) {

        BST bst = new BST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        bst.root = bst.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("inorder traversal of constructed BST");
        bst.inOrder(bst.root);

    }
}


class BST{

    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }


    }

    Node root;

    BST(){

        root=null;
    }

    Node sortedArrayToBST(int arr[], int start, int end){

        if(start>end){
            return null;
        }

        int mid= (start+end)/2;

        Node node = new Node(arr[mid]);


        node.left= sortedArrayToBST(arr, start,mid-1);
        node.right= sortedArrayToBST(arr, mid+1,end);
        return node;
    }


    public void inOrder(Node root){


        if(root!=null){
           inOrder(root.left);
            System.out.print(" "+root.data);
            inOrder(root.right);
        }
    }
}