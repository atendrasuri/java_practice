package com.suri.GSCoderpad;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/02/19
 * @Description: (Overwrite)
 * 2nd smallest element of a sorted rotated array. E.g. 5,6,1,2,3,4
 * @History:
 */
public class SecondSmallestRotatedArray {

    public static void main(String[] args) {

        int arr[]={4,5,6,1,2,3};

        System.out.println(" "+secondSmallest(arr));

    }

    public static int secondSmallest(int arr[]){


        int n = arr.length;
        int index= Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            if(arr[i]>arr[i+1]){
                index= i+2;
                break;
            }
        }

        if(index==Integer.MIN_VALUE){
            index=1;
        }
        else if(index>=n){
           index=0;
        }

        return arr[index];
    }
}