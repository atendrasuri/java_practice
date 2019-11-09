package com.suri.leetcode.medium;

import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Soln_120_Triangle {
  public static void main(String[] args) {

  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
      }
    }
    return A[0];
  }

  public int minimumTotal1(List<List<Integer>> triangle) {

    int sum = 0;

    for (List<Integer> list : triangle) {

      int min = findMin(list);
      sum += min;
    }
    return sum;
  }

  public int findMin(List<Integer> list) {

    int min = list.get(0);

    for (int a : list) {
      if (a < min) {
        min = a;
      }
    }
    return min;
  }
}