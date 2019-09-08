package com.suri.companyWise.AmazonInterview;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 09/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class MaxAreaOfIsland {
  public static void main(String[] args) {
    int grid[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    System.out.println(maxAreaOfIsland(grid));

  }

  public static int maxAreaOfIsland(int[][] grid) {

    if (grid.length == 0) {
      return 0;
    }

    int maxArea = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          maxArea = Math.max(maxArea, doDfs(grid, i, j));
        }
      }
    }
    return maxArea;
  }

  public static int doDfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
      return 0;
    }
    int count = 1;
    grid[i][j] = 0;

    count += doDfs(grid, i + 1, j);
    count += doDfs(grid, i - 1, j);
    count += doDfs(grid, i, j + 1);
    count += doDfs(grid, i, j - 1);

    return count;
  }
}