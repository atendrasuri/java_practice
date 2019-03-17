package com.suri.datastructure.arrays.singledimension.subArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/12/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SubArraywithSumZero {
    public static void main(String[] args) {
        int arr[] = {1, 4, -2, -2, 5, -4, 3};

        if (isSumZero(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");


    }

    public static boolean isSumZero(int arr[]) {
        int n = arr.length;

        Map<Integer, Integer> summap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (arr[i] == 0 || sum == 0 || summap.get(sum) != null) {
                return true;
            }

            summap.put(sum, i);
        }

        return false;
    }


}

