package com.suri.datastructure.arrays.matrix;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DuplicateInMatrix {

    public static void main(String[] args) {

        int arr[][]= {{1,2,4},
                {1,5,7},
                {2,4,8}};

        findDuplicate(arr,3,3);
    }

    public static void findDuplicate(int arr[][], int ROW, int COL){


        for(int i=0;i<ROW*COL;i++){
            int x1= arr[i/ROW][i%COL];

            for(int j=i+1; j<ROW*COL;j++){

                int x2= arr[j/ROW][j%COL];

                if(x1==x2){
                    System.out.println(" duplicate element "+x2);
                }
            }
        }
    }
}