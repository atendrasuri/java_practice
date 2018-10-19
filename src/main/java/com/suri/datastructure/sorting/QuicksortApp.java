package com.suri.datastructure.sorting;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/09/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class QuicksortApp {

    public static void main(String args[]){

        int arr[] = {10,80,30,90,40,50,70};
        quickSort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


    public static void quickSort(int arr[], int l, int r){

        if(l<r){
            int q = partition(arr,l,r);
            quickSort(arr,l,q-1);
            quickSort(arr,q+1,r);

        }


    }
    public static int partition(int arr[], int l, int r){


        int i=l-1;
        int pivot = arr[r];
        for(int j=l;j<r;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp =arr[i+1];
        arr[i+1]=pivot;
        arr[r]=temp;

        return i+1;
    }
}
