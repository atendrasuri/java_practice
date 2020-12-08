package com.suri.companyWise.AGoldmanSach;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Find number of Positional Elements
 * Given a matrix of integers, task is to find out number of positional elements. A positional element is one which is either minimum or maximum in a row or in a column.
 *
 * Examples:
 *
 * Input : a = {{1, 3, 4}, {5, 2, 9}, {8, 7, 6}}
 * Output : 7
 * There are total 7 elements min elements are 1, 2, 6 and 4. And max elements are 9, 8 and 7.
 *
 * Input : a = {{1, 1}, {1, 1}, {1, 1}}
 * Output : 4
 *
 * Soln:- Idea is to store the maximum and minimum of every row and column and then check for the required condition.
 */
public class NumberOfPositionalElements {
  public static void main(String[] args) {

    int a[][] = new int[][]{{1, 3, 4}, {5, 2, 9}, {8, 7, 6}};
    int m = 3, n = 3;
    System.out.println(countPositional(a, m, n));

  }

  static int countPositional(int a[][], int m, int n) {
    // rwomax[i] is going to store maximum of
    // i-th row and other arrays have similar
    // meaning
    int rowmax[] = new int[m];
    int rowmin[] = new int[m];
    int colmax[] = new int[n];
    int colmin[] = new int[n];

    // Find rminn and rmaxx for every row
    for (int i = 0; i < m; i++) {
      int rminn = Integer.MAX_VALUE;
      int rmaxx = Integer.MIN_VALUE;
      for (int j = 0; j < n; j++) {
        if (a[i][j] > rmaxx)
          rmaxx = a[i][j];
        if (a[i][j] < rminn)
          rminn = a[i][j];
      }
      rowmax[i] = rmaxx;
      rowmin[i] = rminn;
    }

    // Find cminn and cmaxx for every column
    for (int j = 0; j < n; j++) {
      int cminn = Integer.MAX_VALUE;
      int cmaxx = Integer.MIN_VALUE;
      for (int i = 0; i < m; i++) {
        if (a[i][j] > cmaxx)
          cmaxx = a[i][j];
        if (a[i][j] < cminn)
          cminn = a[i][j];
      }

      colmax[j] = cmaxx;
      colmin[j] = cminn;
    }

    // Check for optimal element
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((a[i][j] == rowmax[i])
                || (a[i][j] == rowmin[i])
                || (a[i][j] == colmax[j])
                || (a[i][j] == colmin[j])) {
          count++;
        }
      }
    }

    return count;
  }
}