package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/04/19
 * @Description: (Overwrite)
 * Given two sorted arrays, the task is to merge them in a sorted manner.
 *
 * Examples:
 *
 * Input :  arr1[] = { 1, 3, 4, 5}
 *          arr2[] = {2, 4, 6, 8}
 * Output : arr3[] = {1, 2, 3, 4, 5, 6, 7, 8}
 *
 * Input  : arr1[] = { 5, 8, 9}
 *          arr2[] = {4, 7, 8}
 * Output : arr3[] = {4, 5, 7, 8, 8, 9}
 */
public class MergeTwoSortedArray {

    public static void main(String[] args) {

       int  arr1[] = { 1, 3, 4, 5};
       int arr2[] = {2, 4, 6, 8};

       int arr3[]= mergeTwoSortedArray(arr1,arr2);

       for(int i:arr3){
           System.out.print(i+" ");
       }

    }


    public static int[] mergeTwoSortedArray(int arr1[],int arr2[]){


        int i=0;
        int j=0;
        int k=0;
        int arr3[]= new int[arr1.length+arr2.length];

        while(i<arr1.length && j<arr2.length){


            if(arr1[i]<arr2[j]){
                arr3[k]= arr1[i];
                i++;
                k++;
            }else{
                arr3[k]= arr2[j];
                j++;
                k++;
            }
        }

        while(i<arr1.length){
            arr3[k]= arr1[i];
            i++;
            k++;
        }

        while(j<arr2.length){
            arr3[k]= arr2[j];
            j++;
            k++;
        }

        return arr3;
    }
}