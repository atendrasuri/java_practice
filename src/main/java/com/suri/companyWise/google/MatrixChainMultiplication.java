package com.suri.companyWise.google;

/**
 Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

 We have many options to multiply a chain of matrices because matrix multiplication is associative. In other words, no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:

 (ABC)D = (AB)(CD) = A(BCD) = ....
 However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency. For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,

 (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
 A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
 Clearly the first parenthesization requires less number of operations.
 */
public class MatrixChainMultiplication {
  public static void main(String[] args) {
    int arr[] = new int[]{1, 2, 3, 4};
    int size = arr.length;

    System.out.println("Minimum number of multiplications is " +
            matrixChainOrrder(arr, size));

  }

  public static int matrixChainOrrder(int p[], int n) {


    int m[][] = new int[n][n];

    for (int i = 1; i < n; i++) {
      m[i][i] = 0;
    }

    for (int L = 2; L < n; L++) {


      for (int i = 1; i < n - L + 1; i++) {

        int j = L + i - 1;
        if (j == n) {
          continue;
        }

        m[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
          if (q < m[i][j]) {
            m[i][j] = q;
          }
        }
      }
    }
    return m[1][n - 1];
  }
}