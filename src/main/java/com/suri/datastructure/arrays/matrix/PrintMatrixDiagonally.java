package com.suri.datastructure.arrays.matrix;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/08/19
 * @Description: (Overwrite)
 * Given a 2D matrix, print all elements of the given matrix in diagonal order. For example, consider the following 5 X 4 input matrix.
 * <p>
 * 1     2     3     4
 * 5     6     7     8
 * 9    10    11    12
 * 13    14    15    16
 * 17    18    19    20
 * Diagonal printing of the above matrix is
 * <p>
 * 1
 * 5     2
 * 9     6     3
 * 13    10     7     4
 * 17    14    11     8
 * 18    15    12
 * 19    16
 * 20
 */
public class PrintMatrixDiagonally {

  public static void main(String[] args) {


    int arr[][] = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}};

    printMatrixDiagonal(arr);

  }

  public static void printMatrixDiagonal(int arr[][]) {

    int rowCount = arr.length;
    int colCount = arr[0].length;


    for (int k = 0; k < rowCount; k++) {
      for (int row = k, col = 0; row >= 0 && col < colCount; row--, col++) {
        System.out.print(arr[row][col]+" ");
      }
      System.out.println();
    }

    for (int k = 1; k < colCount; k++) {

      for (int row = rowCount - 1, col = k; row >= 0 && col < colCount; row--, col++) {
        System.out.print(arr[row][col]+" ");
      }
      System.out.println();
    }
  }
}