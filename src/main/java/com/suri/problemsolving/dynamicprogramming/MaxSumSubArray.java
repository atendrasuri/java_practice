package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/11/18
 * @Description: (Overwrite)
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 * @History:
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        maxsum(arr);
        //System.out.println(kandane(arr));

    }


    public static void maxsum(int arr[]) {

        int start = 0, end = 0, s = 0;

        int max_so_far = arr[0];
        int max_ending_here = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + arr[i];
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
                start = s;
                end = i;

            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }

        }

        System.out.println("Maximum sum is " + max_so_far);
        System.out.println("starting index:- " + start + "ending index:- " + end);
    }
    public static int kandane(int[] arrA) {
        int max_end_here = 0;
        int max_so_far = 0;
        for (int i = 0; i < arrA.length; i++) {
            max_end_here += arrA[i];
            if (max_end_here < 0) {
                max_end_here = 0;
            }
            if (max_so_far < max_end_here) {
                max_so_far = max_end_here;
            }
        }
        return max_so_far;
    }
}
