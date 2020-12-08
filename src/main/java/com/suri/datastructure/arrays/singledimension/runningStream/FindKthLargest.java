package com.suri.datastructure.arrays.singledimension.runningStream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FindKthLargest {

    public static void main(String[] args) {

        int arr[] = {14, 7, 10, 20, 5, 24};
        System.out.println(""+findKth(arr,5));

    }

    public static int findKth(int arr[], int k ){

        heapSort(arr,k);
        for(int i=k;i<arr.length;i++){

            if(arr[0]<arr[i]){
                int temp= arr[0];
                arr[0]= arr[i];
                arr[i]=temp;
                heapSort(arr,k);
            }
        }

        return arr[0];
    }

    /**
     * building heap
     * @param arr
     * @param k
     */
    public static void heapSort(int arr[], int k){
        for(int i=k/2-1;i>=0;i--){
          heapify(arr,i,k);
        }


    }

    /**
     * heapify method
     * @param arr
     * @param i
     * @param n
     */
    public static void heapify(int arr[], int i, int n){
        int largest=i;
        int l= 2*i+1;
        int r= 2*i+2;

        if(l<n && arr[l]<arr[largest]){
            largest=l;
        }
        if(r<n && arr[r]<arr[largest]){
            largest= r;
        }

        if(largest !=i){
            int temp= arr[i];
            arr[i]= arr[largest];
            arr[largest]= temp;
            heapify(arr,i,n);
        }

    }
}