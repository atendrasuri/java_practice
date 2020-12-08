package com.suri.datastructure.arrays.singledimension;

import java.util.HashSet;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FindTripletSumZero {
    public static void main(String[] args) {

        int arr[]= {0, -1, 2, -3, 1};

        System.out.println(" "+findTripLet(arr));
    }


    public static boolean findTripLet(int arr[]){

        int n= arr.length;

        for(int i=0;i<n-1;i++){

            HashSet<Integer> set = new HashSet<>();

            for(int j=0;j<n;j++){
                int x= -(arr[i]+arr[j]);

                if(set.contains(x)){
                    return true;
                }

                set.add(arr[j]);
            }
        }

        return false;
    }
}