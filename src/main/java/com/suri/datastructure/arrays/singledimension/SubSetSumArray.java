package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SubSetSumArray {
    public static void main(String[] args) {

        int arr[]= {1,5,1,6,0,1,0};
        int subset[] = new int [arr.length];
        int res=isSubSetSum(arr,7,subset,arr.length-1,0);

        if(res==0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

    public static int isSubSetSum(int arr[], int sum, int subset[], int n, int k){


        if (sum == 0 ) {
            if(k==4){
                System.out.println("YES");
                for (int i = 0; i < k; i++) {
                    System.out.print(" " + subset[i]);
                }
            }
            System.out.println();
            k = 0;
            return 0;
        }
        if (sum != 0 && n <= 0) {
            return 1;
        }

        subset[k] = arr[n - 1];

        return isSubSetSum(arr, sum - arr[n - 1], subset, n - 1, k + 1) + isSubSetSum(arr, sum, subset, n - 1, k);

    }
}