package com.suri.datastructure.sorting;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FindPairSum {
    public static void main(String[] args) {
        int arr[] = {10,80,30,90,40,50,70};
        findpairSum(arr,0,arr.length-1,110);
    }

    public static void findpairSum(int arr[], int l, int r, int sum){
        int count =0;
        while(l<r){

            if(arr[l]+arr[r]==sum){
                count++;
                System.out.println(arr[l]+"--->"+arr[r]+"=="+sum);
                return;
            }
            else if(arr[l]+arr[r]>sum)
                r--;
            else if(arr[l]+arr[r]<sum)
                l++;
        }
        System.out.println(" total pair =="+count);
    }
}
