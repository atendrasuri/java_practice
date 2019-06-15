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
public class SerializeDeSerializeBinaryTree {
    public static void main(String[] args) {

        SerializeAndDeSerializeBT serializeAndDeSerializeBT = new SerializeAndDeSerializeBT();
        serializeAndDeSerializeBT.createTree();

        serializeAndDeSerializeBT.display();

        serializeAndDeSerializeBT.serialize();

        serializeAndDeSerializeBT.deSerialize();

        serializeAndDeSerializeBT.display();





    }
}

class SerializeAndDeSerializeBT {

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

    SerializeAndDeSerializeBT() {
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

        deSerializeBinaryTree(arrayList);
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

        if (root == null) {
            arrayList.add(-1);
            return;
        }

        arrayList.add(root.data);
        serializeBinaryTree(root.left, arrayList);
        serializeBinaryTree(root.right, arrayList);


    }

    public Node deSerializeBinaryTree(ArrayList<Integer> arrayList) {

        if (index == arrayList.size() || arrayList.get(index) == -1) {

            index = index + 1;
            return null;
        }

        Node root = new Node(arrayList.get(index));

        index += 1;

        root.left = deSerializeBinaryTree(arrayList);
        root.right = deSerializeBinaryTree(arrayList);
        return root;
    }
}