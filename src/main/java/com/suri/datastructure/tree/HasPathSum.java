package com.suri.datastructure.tree;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */

public class HasPathSum {
  public static void main(String[] args) {

    Solution.TreeNode node = new Solution.TreeNode(5);
    Solution.TreeNode root = node;


  }
}


class Solution {

  public static class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  TreeNode root = null;

  public boolean hasPathSum(TreeNode root, int sum) {

    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      if (root.val == sum) {
        return true;
      } else {
        return false;
      }
    }
    if (hasPathSum(root.left, sum - root.val)) {
      return true;
    }

    if (hasPathSum(root.right, sum - root.val)) {
      return true;
    }
    return false;

  }
}