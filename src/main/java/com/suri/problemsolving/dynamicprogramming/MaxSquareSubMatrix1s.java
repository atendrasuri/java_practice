package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class MaxSquareSubMatrix1s {

    public static void main(String[] args) {

        int arr[][]={{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};

        System.out.println(maxSquareSubMatrix(arr));

    }


    public static int maxSquareSubMatrix(int arr[][]) {

        int M = arr.length;
        int N = arr[0].length;

        int dp[][] = new int[M + 1][N + 1];

        for (int i = 0; i < M+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < N+1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < M+1; i++) {

            for (int j = 1; j < N+1; j++) {

                if (arr[i - 1][j - 1] == 1) {

                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]))+1;
                } else {
                    dp[i][j] = 0;
                }

            }
        }



        for(int i=0;i<M+1;i++){
            for(int j=0;j<N+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[M-1][N-1];
    }
}