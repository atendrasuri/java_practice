package com.suri.problemsolving.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 10/11/18
 * @Description: (Overwrite)
 * 1. The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * @History:
 */
public class LongestSubsequence {
    public static void main(String[] args) {

        int arr[] ={10,22,9,33,21,50,41,60};
        System.out.println(""+LIS(arr,8));

    }


    public static int LIS(int arr[], int n){

        int lis[] = new int[n];
        for(int i=0;i<n;i++){
            lis[i]=1;
        }

        for(int i=1;i<n;i++){

            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&& lis[i]<lis[j]+1){
                    lis[i]= lis[j]+1;
                }
            }
        }
        Arrays.sort(lis);
        return lis[n-1];



    }
}
