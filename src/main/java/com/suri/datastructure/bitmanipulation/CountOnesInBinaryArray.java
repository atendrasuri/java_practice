package com.suri.datastructure.bitmanipulation;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * Given a binary array sorted in non-increasing order, count the number of 1’s in it.
 * Examples:
 * <p>
 * Input: arr[] = {1, 1, 1, 0, 0, 0, 0}
 * Output: 2
 */
public class CountOnesInBinaryArray {

  public static void main(String[] args) {
    int arr[] = {1, 1, 1, 0, 0, 0, 0};

    System.out.println(countOnes(arr));

  }

  public static int countOnes(int arr[]) {

    int n = arr.length;

    int low = 0, high = n - 1;

    while (low <= high) {

      int mid = (low + high) / 2;

      if (arr[mid] == 1 && arr[mid + 1] == 0) {
        return mid + 1;
      }

      if (arr[mid] == 1) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return 0;
  }
}