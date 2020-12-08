package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class MaxSumNoAdj {

    public static void main(String[] args) {

        int arr[] = {5, 5, 10, 100, 10, 5};

        System.out.println(""+findMaxSum(arr));
    }

    public static int findMaxSum(int arr[])
    {
        int n = arr.length;
        int incl =arr[0];
        int excl = 0;
        int excl_new =0;

        for ( int i=1;i<n;i++){
            excl_new = (incl>excl)?incl:excl;
            incl = excl+arr[i];
            excl = excl_new;
        }
        return (incl>excl)?incl:excl;
    }
}
