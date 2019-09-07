package com.suri.datastructure.arrays.singledimension;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
  public static void main(String[] args) {
    int arr[] = {0, 1, 0, 3, 12};
    moveZeroes(arr);
    AtomicInteger ai;
  }

  public static void moveZeroes(int[] nums) {

    int count = 0;
    int n = nums.length;
    int i = 0;
    while (i < n) {

      if (nums[i] != 0) {
        nums[count++] = nums[i];
      }
      i++;
    }
    while (count < n) {
      nums[count++] = 0;
    }

  }
}