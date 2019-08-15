package com.suri.datastructure.arrays.matrix;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 12/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * Given a sorted matrix where rows and the columns are sorted.
 * Write an algorithm to search an element in the matrix in O(n).
 */
public class SearchElementSortedMatrix {
  public static void main(String[] args) {

    int[][] mat = {{2, 6, 7, 11},
            {3, 8, 10, 12},
            {4, 9, 11, 13},
            {5, 15, 16, 18}
    };
    System.out.println(stairSearch(mat, 9));

  }


  public static boolean stairSearch(int arr[][], int key) {

    // assuming square sub matrix
    int n = arr.length;


    if (key < arr[0][0] && key > arr[n - 1][n - 1]) {
      return false;
    }


    int r = 0;
    int c = n - 1;

    while (r < n && c >= 0) {

      if (key > arr[r][c]) {

        r++;
      } else if (key < arr[r][c]) {
        c--;
      } else {
        return true;
      }
    }

    return false;
  }
}