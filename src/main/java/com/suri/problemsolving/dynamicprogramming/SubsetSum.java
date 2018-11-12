package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 10/11/18
 * @Description: (Overwrite)
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * Example:
 * <p>
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 * @History:
 */
public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int subset[] = new int[arr.length];
        int sum = 7;
        isSubSetSum(arr, sum,subset, arr.length, 0);
        //System.out.println(res);

    }

    public static int isSubSetSum( int arr[], int sum,int subset[], int n, int k) {

        if (sum == 0) {
            for (int i = 0; i < k; i++) {
                System.out.print(" " + subset[i]);
            }
            System.out.println();
            k=0;
            return 0;
        }
        if (sum != 0 && n <= 0) {
            return 1;
        }
        subset[k] = arr[n-1];

        return isSubSetSum(arr,sum-arr[n-1],subset,n - 1, k + 1)+isSubSetSum(arr,sum,subset, n - 1, k);

    }
}
