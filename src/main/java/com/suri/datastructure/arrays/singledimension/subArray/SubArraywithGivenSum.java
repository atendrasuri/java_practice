package com.suri.datastructure.arrays.singledimension.subArray;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 01/03/19
 * @Description: (Overwrite)
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 * Examples :
 * <p>
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 * <p>
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Ouptut: Sum found between indexes 1 and 4
 * <p>
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 */


public class SubArraywithGivenSum {

    public static void main(String[] args) {


        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;

        System.out.println(subArraySum(arr,sum));
    }

    public static int subArraySum(int arr[], int sum) {


        int curr_sum = arr[0];
        int start = 0;
        int i;
        int n = arr.length;


        for (i = 1; i < n; i++) {

            while (curr_sum > sum) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            if (curr_sum == sum) {
                System.out.println(" subArray found with sum " + start + "  " + (i - 1));
                return 1;
            }
            if (i < n) {
                curr_sum = curr_sum + arr[i];
            }
        }

        System.out.println(" Sum not found with subarray");
        return -1;
    }
}