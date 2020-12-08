package com.suri.datastructure.arrays.singledimension;

import java.util.LinkedList;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class MaximumFromEachSubarraySizeK {
    public static void main(String[] args) {

        int[] array = {9,6,11,8,10,5,14,13,93,14};
        int k = 4;

        printMaxfromEachSubarray(array,k);

    }


    public static void printMaxfromEachSubarray(int arr[], int k){


        LinkedList<Integer> list = new LinkedList<>();


        for(int i=0;i<k;i++){

            // remove all useless elements present at the front of the list
            while(!list.isEmpty()&& arr[list.getLast()]<arr[i]){
                list.removeLast();
            }
            // add index of current element at the back
            list.add(i);
        }


        for(int i=k;i<arr.length;i++){
            // first element present in the list is the greatest element for the last 'k' sized sub-array
            System.out.print(arr[list.getFirst()]+"  ");

            // now remove all indices of elements from the list which do not belong to current window
            while(!list.isEmpty() && list.getFirst()<(i-k+1)){
                list.removeFirst();
            }

             // now again remove all useless elements present at the front of the list
            // remove all useless elements present at the front of the list
            while(!list.isEmpty()&& arr[list.getLast()]<arr[i]){
                list.removeLast();
            }
            // and finally insert this new element at the back of the list
            list.add(i);
        }
        // now print the largest element from the last sub-array(window)
        System.out.print(arr[list.getFirst()]);
    }
}