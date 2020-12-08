package com.suri.datastructure.tree.huffmanDecoding;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/03/19
 * @Description: (Overwrite)
 * S="1001011"
 * Processing the string from left to right.
 * S[0]='1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 * We move back to the root.
 *
 * S[1]='0' : we move to the left child.
 * S[2]='0' : we move to the left child. We encounter a leaf node with value 'B'. We add 'B' to the decoded string.
 * We move back to the root.
 *
 * S[3] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 * We move back to the root.
 *
 * S[4]='0' : we move to the left child.
 * S[5]='1' : we move to the right child. We encounter a leaf node with value C'. We add 'C' to the decoded string.
 * We move back to the root.
 *
 *  S[6] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 * We move back to the root.
 *
 * Decoded String = "ABACA"
 *
 * @History:
 */
public class HuffmanDecoding {
    class Node{
        int data;
        Node left,right;
    }
    public static void main(String[] args) {

    }


    void decode(String s, Node root) {

        StringBuilder sb = new StringBuilder();

        if (root == null) {
            return;
        }
        Node temp = root;

        for (int i = 0; i < s.length(); i++) {

            temp = s.charAt(i) == '1' ? temp.right : temp.left;

            if (temp.left == null && temp.right == null) {
                sb.append(temp.data);
                temp = root;
            }
        }
        System.out.println(sb.toString() + "");

    }

}