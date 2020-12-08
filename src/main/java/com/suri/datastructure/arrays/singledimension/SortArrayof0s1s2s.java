package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 23/04/19
 * @Description: (Overwrite)
 *Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 */
public class SortArrayof0s1s2s {

    public static void main(String[] args) {

        int arr[] = { 0, 1, 1, 0, 1, 2, 1,
                2, 0, 0, 0, 1 };

        threeWayPartition(arr,arr.length-1);
        printArray(arr);

    }


    public static void printArray(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void threeWayPartition(int arr[], int end){

        int start=0;
        int pivot=1;
        int mid=0;

        while(mid<=end){

            if(arr[mid]<pivot){
                swap(arr,start,mid);
                ++start;
                ++mid;
            }
            else if(arr[mid]>pivot){
                swap(arr,mid, end);
                --end;
            }else{
                ++mid;
            }
        }



    }

    public static void swap(int arr[], int i, int j){

        int temp=arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
}