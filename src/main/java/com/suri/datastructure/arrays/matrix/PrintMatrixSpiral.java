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
public class PrintMatrixSpiral {

    public static void main(String[] args) {

        int ROW = 4;
        int COL = 4;
        int arr[][] = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        printSpiral(arr,ROW,COL);

    }

public static void printSpiral(int arr[][], int ROW, int COL){


        int rptr=0;
        int cptr=0;


        while(rptr<ROW && cptr<COL){

            // print the first row from remaining rows

            for(int i=cptr;i<COL;i++){
                System.out.print(arr[rptr][i]+" ");
            }
            rptr++;

            // print last column from the remaining columns

            for(int i=rptr;i<ROW;i++){
                System.out.print(arr[i][COL-1]+" ");
            }
            COL--;

            //print the last row from the remaining row

            if(rptr<ROW){
                for(int i=COL-1;i>=cptr;i--){
                    System.out.print(arr[ROW-1][i]+" ");
                }
                ROW--;
            }
           //print the first column from remaining column.

            if(cptr<COL){
                for(int i= ROW-1;i>=rptr;i--){
                    System.out.print(arr[i][cptr]+" ");
                }
                cptr++;
            }
        }

   }

}