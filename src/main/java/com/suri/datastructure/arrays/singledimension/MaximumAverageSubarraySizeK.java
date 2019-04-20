package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/04/19
 * @Description: (Overwrite)
 * Given an integer array and a number k, print the maximum sum subarray of size k.
 * Maximum average subarray of size k is a subarray (sequence of contiguous elements in the array) for which the average is maximum among all subarrays of size k in the array.
 * Average of k elements = (sum of k elements)/k
 * Since k > 0, the maximum sum subarray of size k will also be maximum average subarray of size k.
 * So, the problem reduces to finding maximum sum subarray of size k in the array.
 */
public class MaximumAverageSubarraySizeK {
    public static void main(String[] args) {

        int[] input = {11, -8, 16, -7, 24, -2, 3};
        int k = 3;
        printMaxAvgSubarray(input, k);

    }
    public static void printMaxAvgSubarray(int[] input, int k) {
        System.out.print("Maximum average subarray of length " + k + " is:  ");
        int index = getMaxAvgSubarrayStartIndex(input, k);
        for(int i =0 ; i < k; i++) {
            System.out.print(input[index++] + " ");
        }
    }

    public static int getMaxAvgSubarrayStartIndex(int arr[], int k){

        int n= arr.length;
        if (k > n)
            throw new IllegalArgumentException("k should be less than or equal to n");

        if(k == n) {
            return 0;   // whole array is the solution
        }

        int sum=arr[0];

        for(int i=1;i<k;i++){
                sum+= arr[i];
        }

        int maxSum=sum;
        int maxSumStartIndex= 0;

        for(int i=k;i<n;i++){
            // Remove first element of the current window and add next element to the window
            sum= sum-arr[i-k]+arr[i];

            if(sum>maxSum){
                sum=maxSum;
                maxSumStartIndex=i-k;
            }
        }

        return maxSumStartIndex+1;
    }
}