package com.suri.datastructure.sorting;

import java.util.Arrays;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/11/18
 * @Description: (Overwrite)
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2
 * @History:
 */
public class PythagoreanTriplet {
    public static void main(String[] args) {

        int ar[] = {3, 1, 4, 6, 5};
        System.out.println(isTriplet(ar,ar.length));

    }

    static boolean isTriplet(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        //Arrays.sort(arr);
        QuicksortApp.quickSort(arr, 0, arr.length - 1);

        for (int i = n - 1; i >= 2; i--) {


            int l = 0;
            int r = i - 1;

            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    System.out.println(arr[l]+" + "+ arr[r]+" = "+ arr[i]);
                    return true;
                }
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }


}
