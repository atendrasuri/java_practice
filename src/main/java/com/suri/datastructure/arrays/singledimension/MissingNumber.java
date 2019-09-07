package com.suri.datastructure.arrays.singledimension;

import java.util.Stack;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * <p>
 * LeetCode:-268
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
  public static void main(String[] args) {

    int arr[]={9,6,4,2,3,5,7,0,1};
    int arr1[]={3,0,1};
    System.out.println(missingNumber(arr1));

  }

  public static int missingNumber(int[] nums) {

    int actualCount=0;
    int countOfNumbers=0;
    for(int i=0;i<nums.length;i++){
      countOfNumbers+=nums[i];
      actualCount+=i;

    }
    actualCount+=nums.length;
    return actualCount-countOfNumbers;
  }
}