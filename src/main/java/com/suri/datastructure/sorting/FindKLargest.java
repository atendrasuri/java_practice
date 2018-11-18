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
public class FindKLargest {
    public static void main(String[] args) {
        int arr[] = {10,80,30,90,40,50,70};

        bubbleSort(arr, arr.length-1, 3);
        for(int i=arr.length-3;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    public static void bubbleSort(int arr[], int n, int k){
         boolean swap;
        for(int i=0;i<k;i++){
             swap=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];arr[j]=arr[j+1];arr[j+1]=temp;
                    swap =true;
                }
            }
            if(swap==false)
                break;
        }
    }
}
