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
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 * Solution:-
 *
 * Let’s start our search from the top-right corner of the array. There are three possible cases.
 *
 * The number we are searching for is greater than the current number.
 * This will ensure, that all the elements in the current row is smaller than the number we are searching for as we are already at the right-most element and the row is sorted.
 *Thus, the entire row gets eliminated and we continue our search on the next row. Here elimination means we won’t search on that row again.
 *
 * The number we are searching for is smaller than the current number. This will ensure, that all the elements in the current column is greater than the number we are searching for. Thus, the entire column gets eliminated and we continue our search on the previous column i.e. the column at the immediate left.
 *
 * The number we are searching for is equal to the current number. This will end our search.
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