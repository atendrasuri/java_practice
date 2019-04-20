package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/04/19
 * @Description: (Overwrite)
 * Given an array of integers, print the leaders in the array.
 * A leader is an element which is larger than all the elements in the array to its right.
 * For example:
 * Input Array:
 * { 98, 23, 54, 12, 20, 7, 27 }
 * Output:
 * Leaders- 27 54 98
 * @History:
 */
public class LeadersInArray {
    public static void main(String[] args) {
        int[] input = { 98, 23, 54, 12, 20, 7, 27 };
        leadersInArray(input);

    }

    public static void leadersInArray(int arr[]){

        if(arr.length==0){
            return;
        }

        int leaderElement = arr[arr.length-1];

        System.out.print(leaderElement+" ");

        for(int i=arr.length-2; i>=0;i--){

            if(arr[i]>leaderElement){
                leaderElement=arr[i];
                System.out.print(leaderElement+" ");
            }
        }
    }
}