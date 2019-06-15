package com.suri.datastructure.tree;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/06/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PrintElementsExceptBoundary {



        public static void main(String[] args) {

            VerticalBinaryTree1 verticalBinaryTree1= new VerticalBinaryTree1();

            verticalBinaryTree1.createTree();
            verticalBinaryTree1.display();
            System.out.println();
            verticalBinaryTree1.displayVerticalOrder();

        }
    }

    class VerticalBinaryTree1{
        class Node{

            int data;
            Node left,right;

            Node(int data){
                this.data=data;
                left=right=null;
            }
        }

        Node root;

        VerticalBinaryTree1(){
            root=null;
        }



        public void display(){
            inOrder(root);
        }


        public void displayVerticalOrder(){

            TreeMap<Integer, ArrayList<Integer>> map= new TreeMap<>();

            printVerticalOrder(root,0,map);

            for(Integer hd:map.keySet()){

                ArrayList list= map.get(hd);

                for(int i=0;i<list.size();i++){
                    if(i!=0 && i!=list.size()-1){
                        System.out.println(list.get(i)+" ");
                    }
                }

                //list.stream().forEach(System.out::print);
                System.out.println();
            }
        }


        public void createTree()
        {
            this.root = new Node(1);

            Node n1 = new Node(2);
            Node n2 = new Node(3);

            Node n4 = new Node(4);
            Node n5 = new Node(5);
            Node n6 = new Node(6);
            Node n7 = new Node(7);

            Node n8 = new Node(8);
            Node n9 = new Node(9);

            root.left  = n1;
            root.right = n2;

            n1.left  =  n4;
            n1.right = n5;

            n2.left  = n6;
            n2.right = n7;

            n6.left=n8;
            n6.right=n9;
        }

        public void inOrder(Node root){

            if(root==null){
                return;
            }

            inOrder(root.left);
            System.out.print(" "+root.data);
            inOrder(root.right);

        }

        public void printVerticalOrder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> map){

            if(root==null){
                return;
            }

            ArrayList list = new ArrayList();
            if(map.get(hd)!=null){
                list=map.get(hd);
            }
            list.add(root.data);
            map.put(hd,list);
            printVerticalOrder(root.left,hd-1,map);
            printVerticalOrder(root.right,hd+1,map);

        }

}