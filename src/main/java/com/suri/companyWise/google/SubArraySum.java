package com.suri.companyWise.google;

import java.util.Scanner;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 30/12/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SubArraySum {
  public static void main(String[] args) {

      sumSubArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},10,15) ;

    }

  public static void sumSubArray(int arr[], int n, int s){


    int sum=0;
    int start=0;
    for(int i=0;i<n;i++){
      while(sum>s){
        sum=sum-arr[start];
        start++;
      }
      if(sum==s){
        System.out.println(start+1+" "+i);
      }else{
        sum+= arr[i];
      }
    }

  }
}