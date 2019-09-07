package com.suri.datastructure.arrays.singledimension;

import java.util.PriorityQueue;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 02/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
  public static void main(String[] args) {

    int arr[] = {1, 2, 0};
    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
    System.out.println(firstMissingPositive.firstMissingPositive(arr));


    System.out.println();

    int arr2[] = {7, 8, 9, 11, 12};
    System.out.println(firstMissingPositive.findSmallestPositive(arr2));
  }

  //First Approach
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 1 && nums[i] <= n) {
        int pos = nums[i] - 1;
        if (nums[pos] != pos + 1) {
          swap(nums, pos, i);
          i--;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    return n + 1;
  }


  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


  // second approach

  public int findSmallestPositive(int arr[]) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= 0) {
        minHeap.add(arr[i]);
      }
    }

    int c = 0;
    while (!minHeap.isEmpty()) {
      if (minHeap.peek() == c || minHeap.peek() - 1 == c) {
        c = minHeap.remove();
      } else {
        return c + 1;
      }
    }
    return c + 1;
  }
}