package com.suri.datastructure.sorting;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/11/18
 * @Description: (Overwrite)
 *
 * @History:
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int arr[] = {10,80,30,90,40,50,70};
        quickSort(arr,0,arr.length-1,2);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    public static void quickSort(int arr[], int l, int r, int k){

        if(l<=r){

            int q= partition(arr,l,r);

            if(q==k-1)
            {
                System.out.println("q-->"+ q+"-->"+k+"th smallest Element is "+arr[q]);
                return;
            }
            quickSort(arr,l,q-1, k);
            quickSort(arr,q+1,r, k);
        }
    }

    public static int partition(int arr[], int l, int r){

        int pivot = arr[r];
        int i = l-1;

        for(int j =l;j<r;j++){

            if(arr[j]<=pivot){
                i++;
                int temp=arr[i];arr[i]=arr[j];arr[j]=temp;
            }
        }
        int temp =arr[i+1];arr[i+1]=arr[r];arr[r]=temp;

        return i+1;
    }
}
