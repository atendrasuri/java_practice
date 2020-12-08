package com.suri.datastructure.arrays.singledimension.subArray;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SmallestSubArrraywithGivenSum {
    public static void main(String[] args) {

        int arr[] = {1, 4, 20, 3, 4, 23, 33};
        int sum = 27;

        System.out.println(smallestSubArrayWithGivenSum(arr, sum));

    }


    public static int smallestSubArrayWithGivenSum(int arr[], int sum) {


        int currsum = 0;
        int start = 0;
        int n = arr.length;
        int len = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            while (currsum > sum) {
                currsum = currsum - arr[start];
                start++;
            }
            if (sum == currsum) {
                System.out.println(" found with " + start + " and " + (i - 1));

                int currLength = i - start;
                if (currLength < len) {
                    len = currLength;
                }
                System.out.println(" Length is " + len);
            }

            if (i < n) {
                currsum = currsum + arr[i];
            }
        }

        return len;
    }
}