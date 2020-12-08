package com.suri.datastructure.arrays.singledimension.subArray;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/07/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * You are given a sorted array containing only numbers 0 and 1.
 * Find the transition point efficiently. Transition point is a point where "0" ends and "1" begins.
 */
public class FindTransitionPoint {

    public static void main(String[] args) {
        int arr[] = {0,0,0,1,1};

        System.out.println(transitionPoint(arr,5));

    }
    static int transitionPoint(int arr[],int n)
    {
        for(int i=0;i<n;i++){
            int res= arr[i]&1;
            if(res==1){
                return i;

            }
        }
        return -1;
    }
}