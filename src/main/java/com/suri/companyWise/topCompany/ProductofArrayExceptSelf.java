package com.suri.companyWise.topCompany;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 01/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History: Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
  public static void main(String[] args) {
    int arr[] ={1,2,3,4};

    int result[] = productExceptSelf(arr);

  }

  public static int[] productExceptSelf(int[] nums) {

    int result[] = new int[nums.length];

    int left[] = new int[nums.length];
    int right[] = new int[nums.length];

    int n = nums.length;

    left[0] = 1;
    right[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      left[i] = left[i - 1] * nums[i - 1];
    }

    for (int i = n - 2; i >= 0; i--) {
      right[i] = right[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < n; i++) {
      result[i] = left[i] * right[i];
    }

    return result;

  }
}