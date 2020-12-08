package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 10/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class RotateArray {

    public static void main(String[] args) {

        int arr[]={1, 2, 3, 4, 5};



       // int arr1[]= rotLeft(arr,4);

        int arr1[]= rotateRight(arr,2);

        for(int a:arr1){
            System.out.print(a+"  ");
        }

    }

    static int[] rotLeft(int[] arr, int d) {
        int j;
        for(int i=1;i<=d;i++){
            int temp=arr[0];
            for(j=0;j<arr.length-1;j++){
                arr[j]=arr[j+1];
            }
            arr[j]=temp;
        }
        return arr;
    }

    static int[] rotateRight(int arr[], int k){
        int n= arr.length;
        int j;

        for(int i=1;i<=k;i++ ){

            int temp = arr[0];

            for( j=1;j<n;j++){

                arr[j-1]= arr[j];

            }
            arr[j-1]= temp;
        }
        return arr;
    }
}