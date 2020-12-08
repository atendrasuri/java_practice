package com.suri.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/07/19
 * @Description: (Overwrite)
 * Given a Linked List Representation of Complete Binary Tree. The task is to construct the Binary tree.
 *
 * Note : The complete binary tree is represented as a linked list in a way where if root node is stored at position i,
 * its left, and right children are stored at position 2*i+1, 2*i+2 respectively.
 *
 * @History:
 */
public class BinaryTreeFromLinkedList {


    public static Tree convert(Node head, Tree node) {

        if (head == null) {
            return null;
        }

        node = new Tree(head.data);

        Queue<Tree> q = new LinkedList<>();

        head = head.next;
        q.add(node);

        while (head != null) {

            Tree temp = q.remove();
            Tree left = null, right = null;

            left = new Tree(head.data);
            q.add(left);
            head = head.next;
            if (head != null) {
                right = new Tree(head.data);
                q.add(right);
                head = head.next;

            }
            temp.left = left;
            temp.right = right;
        }

        return node;
    }
}

class Tree{
    int data;
    Tree left;
    Tree right;
    Tree(int d){
        data=d;
        left=null;
        right=null;
    }
}
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}