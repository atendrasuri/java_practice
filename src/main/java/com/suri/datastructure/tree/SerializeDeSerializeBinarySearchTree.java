package com.suri.datastructure.tree;

import java.util.ArrayList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/06/19
 * @Description: (Overwrite)
 * Serialization is to store tree in a file so that it can be later restored.
 * The structure of tree must be maintained.
 * Deserialization is reading tree back from file.
 * @History:
 */
public class SerializeDeSerializeBinarySearchTree {
    public static void main(String[] args) {

        SerializeAndDeSerializeBST serializeAndDeSerializeBST = new SerializeAndDeSerializeBST();
        serializeAndDeSerializeBST.createTree();

        serializeAndDeSerializeBST.display();

        serializeAndDeSerializeBST.serialize();

        serializeAndDeSerializeBST.deSerialize();

        serializeAndDeSerializeBST.display();





    }
}

class SerializeAndDeSerializeBST {

    class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;
    int index = 0;
    ArrayList<Integer> arrayList = new ArrayList<>();

    SerializeAndDeSerializeBST() {
        root = null;
    }


    /**
     * helper method
     */

    public void display(){

        inOrder(root);
        System.out.println();
    }

    public void serialize(){


        serializeBinaryTree(root,arrayList);

        arrayList.forEach(x-> System.out.print(x+" "));
        System.out.println();
    }

    public void deSerialize(){

        int preorder[] = new int[arrayList.size()];
        int i=0;
        for(Integer a:arrayList){
            preorder[i]=a;
            i++;
        }
        deSerializeBinarySearchTree(preorder,0,arrayList.size()-1);
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


    public void serializeBinaryTree(Node root, ArrayList<Integer> arrayList) {

       if(root==null){
           return;
       }
        arrayList.add(root.data);
        serializeBinaryTree(root.left, arrayList);
        serializeBinaryTree(root.right, arrayList);


    }

    public Node deSerializeBinarySearchTree(int preOrder[], int low, int high) {

        if(low>high){
            return null;
        }

        Node root= new Node(preOrder[low]);

        int divIndex= findDivision(preOrder, root.data, low+1, high);

        root.left = deSerializeBinarySearchTree(preOrder, low+1, divIndex-1);
        root.right = deSerializeBinarySearchTree(preOrder, divIndex, high);
        return root;
    }


    public int findDivision(int preOrder[], int val, int low, int high ) {
        int i;
        for( i=low; i<=high;i++){
            if(val<preOrder[i]){
                break;
            }
        }
        return i;
    }
}