package com.suri.companyWise.AmazonInterview;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a binary tree, imagine yourself standing on the left side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * Input:
 * 2
 * 2
 * 1 2 R 1 3 L
 * 4
 * 10 20 L 10 30 R 20 40 L 20 60 R
 *
 * Output:
 * 1 3
 * 10 20 40
 *
 * Explanation:
 * Testcase 2: below is a given tree with its nodes.
 */

public class BinaryTreeLeftSideView {
  public static void main(String[] args) {

  }

  public List<Integer> rightSideView(TreeNode root) {


    List<Integer> rightSideView = new ArrayList<>();
    if (root == null) {
      return rightSideView;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.remove();
        if (i == size - 1) {
          rightSideView.add(current.val);
        }
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }


    }
    return rightSideView;

  }
}