package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 25/04/19
 * @Description: (Overwrite)
 *Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:
 *
 * Example :
 *
 * Input : A[] = {-7, 1, 5, 2, -4, 3, 0}
 * Output : 3
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2]  =  A[4] + A[5] + A[6]
 */

public class EquilibriumIindexOfArray {

    public static void main(String[] args) {

            int arr[]={-7, 1, 5, 2, -4, 3, 0};

        System.out.println(inflectionPoint(arr));

    }
    public static int inflectionPoint(int arr[]){


        int n= arr.length;

        int sum=0;
        int leftSum=0;


        for(int i=0;i<n;i++){
            sum+= arr[i];
        }

        for(int i=0;i<n;i++){
            sum-= arr[i];

            if(leftSum==sum){
                return i;
            }
            leftSum= leftSum+arr[i];
        }
        return -1;
    }
}