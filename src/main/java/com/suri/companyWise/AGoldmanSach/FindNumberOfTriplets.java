package com.suri.companyWise.AGoldmanSach;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/10/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given an array arr of size N. The task is to count number of triplets in the array such that a[i]<a[j]<a[k] OR a[i]></a[k]>a[j]>a[k] and i<j<k
 */
public class FindNumberOfTriplets {
  public static void main(String[] args) {
    int arr[] = {10, 8, 3, 1};

    System.out.println(countTriplet(arr));

  }

  public static  int countTriplet(int arr[]){

    if(arr.length==0){
      return 0;
    }
    int n= arr.length;

    int count=0;

    for(int i=0;i<n-2;i++){
      for(int j=i+1;j<n-1;j++){
        for(int k=j+1;k<n;k++){
          if((arr[i]<arr[j]  && arr[j]<arr[k])||
                  (arr[i]>arr[j] && arr[j]>arr[k])){
            count++;
          }
        }
      }
    }
    return count;
  }
}