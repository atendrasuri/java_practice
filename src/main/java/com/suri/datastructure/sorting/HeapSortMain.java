package com.suri.datastructure.sorting;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 27/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class HeapSortMain {

    public static void main(String[] args) {

        int arr[]= {12, 11, 13, 5, 6, 7};
        HeapSortMain obj= new HeapSortMain();
        display(arr);
        obj.heapSort(arr);
        display(arr);


    }

    public  void heapSort(int arr[]) {

        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--) {

            heapify(arr, n, i);

        }


        for (int i = n - 1; i >= 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

    }

    public void heapify(int arr[], int n, int i) {


        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l]>arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);

        }



    }


    public static void display(int arr[]){

       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+"   ");
       }
        System.out.println();


    }
}