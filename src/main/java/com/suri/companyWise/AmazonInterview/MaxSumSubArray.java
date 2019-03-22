package com.suri.companyWise.AmazonInterview;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 21/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class MaxSumSubArray {

    public static void main(String[] args) {

        //int arr[]= {-2,-3,4,-1,-2,1,5,-1};
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        maxSum(arr);

    }

    public static void maxSum(int arr[]){


        int n = arr.length;
        int dp[] = new int[n];

        if(arr[0]>0){
            dp[0]=arr[0];
        }
        else{
            dp[0]=0;
        }
        //dp[0]= arr[0];
        int end=0;
        int start=0;


        for(int i=1;i<n;i++){
            dp[i]= Math.max(dp[i-1]+arr[i], arr[i]);

            if(dp[i-1]>dp[i]){
                end=i-1;
            }

            if(dp[i]<0){
                start=i+1;
            }
        }

        int max=0;

        for(int i=0;i<n;i++){
            if(dp[i]>max){
                max= dp[i];
            }
        }

        System.out.println(" max sum is"+ max);
        System.out.println(" start "+start+"  end "+end);
    }
}