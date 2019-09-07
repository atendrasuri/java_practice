package com.suri.datastructure.arrays.singledimension;

import java.util.Arrays;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 05/09/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class K_diffPairsInArray {
  public static void main(String[] args) {

    int arr[]={3,1,4,1,5};
    int k=2;
    K_diffPairsInArray k_diffPairsInArray = new K_diffPairsInArray();
    System.out.println(k_diffPairsInArray.findPairs(arr,k));

  }

  public int findPairs(int[] nums, int k) {


    int i = 0, j = 0, count = 0;
    int n = nums.length;
    Arrays.sort(nums);

    while (j<n) {
      int diff = nums[j] - nums[i];
      if (diff == k) {
        i++;
        j++;
        count++;
      } else if (diff < k) {
        j++;
      } else {
        i++;
      }

    }
    return count;
  }
}