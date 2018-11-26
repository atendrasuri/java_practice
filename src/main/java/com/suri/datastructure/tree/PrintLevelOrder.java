package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 24/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintLevelOrder {


    public static void main(String[] args) {

        BT bst = new BT();
        bst.createBST(20);
        bst.createBST(8);
        bst.createBST(4);
        bst.createBST(10);
        bst.createBST(14);
        bst.createBST(25);
        bst.createBST(22);


        //bst.display();
        bst.displayLeftView();
        //bst.displayRightView();
        //bst.displayLevelOrder();
        //bst.displayLeafNode();
        //bst.displayBounday();


    }
}

class BT {

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;
    static int max_level = 0;

    BT() {
        root = null;

    }

    public void createBST(int data) {
        root = createNode(root, data);
    }

    public void display() {
        inOrder(root);
    }

    public void displayLeftView() {
       // printLeftView(root, 1);
        printBoundayLeft(root);
    }

    public void displayRightView() {
        printRightView(root, 1);
    }

    public void displayLevelOrder(){
        printLevelOrder(root);
    }

    public void displayLeafNode(){
        printLeafNode(root);
    }



    public void displayBounday(){
        printBoundayView(root);
    }


    public Node createNode(Node node, int data) {

        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.data) {
            node.left = createNode(node.left, data);
        }
        if (data > node.data) {
            node.right = createNode(node.right, data);
        }
        return node;
    }

    public void inOrder(Node node) {

        if (node != null) {

            inOrder(node.left);
            System.out.println("  " + node.data);
            inOrder(node.right);
        }
    }

    public void printLeftView(Node node, int level) {

        if (node == null) {
            return;
        }

        if (max_level < level) {
            System.out.println(node.data);
            max_level = level;
        }
        printLeftView(node.left, level + 1);
        printLeftView(node.right, level + 1);

    }

    public void printRightView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (max_level < level) {
            System.out.println(node.data);
            max_level = level;
        }
        printRightView(node.right, level + 1);
        printRightView(node.left, level + 1);
    }

    public void printLevelOrder(Node node){

        int h = findHeightBST(node);

        for(int i=1; i<=h;i++){
            printGivenLevel(node,i);

        }
    }

    public void printGivenLevel(Node node, int level){
        if(node==null)
            return;

        if(level==1){
            System.out.println(node.data);
        }
        printGivenLevel(node.left,level-1);
        printGivenLevel(node.right,level-1);
    }


    public int findHeightBST(Node node){
        if(node==null){
            return 1;
        }
        return 1+ Math.max(findHeightBST(node.left),findHeightBST(node.right));
    }

    public void printLeafNode(Node node){
        if(node!=null) {


            printLeafNode(node.left);
            if (node.right == null && node.left == null) {
                System.out.println(" " + node.data);
            }
            printLeafNode(node.right);
        }
    }

    // print BoundaryLeft

    public void printBoundayLeft(Node node){
        if(node!=null){

            if(node.left!=null){
                System.out.println(" "+node.data);
                printBoundayLeft(node.left);
            }
            else if(node.right!=null){
                System.out.println(""+node.right);
                printBoundayLeft(node.right);
            }

        }
    }

    /*
       print Boundary Right
     */

    public void printBoundaryRight(Node node){
        if(node!=null){


            if(node.right!=null){
                printBoundaryRight(node.right);
                System.out.println(" "+node.data);
            }
            else if(node.left!=null){
                printBoundaryRight(node.left);
                System.out.println(" "+node.data);
            }
        }
    }


    public void printBoundayView(Node node){

        if(node!=null){
            System.out.println("  "+node.data);
            printBoundayLeft(node.left);
            printLeafNode(node.left);
            printLeafNode(node.right);
            printBoundaryRight(node.right);
        }
    }

}