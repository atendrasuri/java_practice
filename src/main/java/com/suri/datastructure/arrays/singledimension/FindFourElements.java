package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FindFourElements {
    public static void main(String[] args) {

        int arr[] = {10, 20, 30, 40, 1, 2};

        findFourElements(arr,33);

    }

    public static void findFourElements(int arr[], int sum) {


        int n = arr.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == sum) {
                            System.out.println(arr[i] + " " + arr[j] + " " + arr[k]
                                    + " " + arr[l] + " == " + sum);
                        }
                    }

                }
            }
        }

    }
}
