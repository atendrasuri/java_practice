package com.suri.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 23/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * <p>
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * <p>
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 */
public class Sol_724_FindPivotIndex {

  public static void main(String[] args) {

    int nums[] = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(nums));

    CountDownLatch countDownLatch;


  }

  public static int pivotIndex(int[] nums) {

    if (nums == null || nums.length == 0) {
      return -1;
    }
    int total = 0, sum = 0;
    for (int num : nums) {
      total += num;
    }


    for (int i = 0; i < nums.length; ) {
      if (sum * 2 == total - nums[i]) {
        return i;
      }
      sum += nums[i++];

    }
    return -1;

  }


}