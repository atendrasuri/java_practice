package com.suri.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Soln_118_Pascal_Triangle {
  public static void main(String[] args) {

    System.out.println(generate(5));

  }

  public static List<List<Integer>> generate(int numRows) {

    List<List<Integer>> result = new ArrayList<>();

    if (numRows == 0) {
      return result;
    }

    int dp[][] = new int[numRows][numRows];

    dp[0][0] = 1;

    List<Integer> list1 = new ArrayList<>();
    list1.add(dp[0][0]);
    result.add(list1);
    for (int i = 1; i < numRows; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j <= i; j++) {

        if (j == 0 || j == i) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }

        list.add(dp[i][j]);
      }
      result.add(list);
    }
    return result;
  }
}