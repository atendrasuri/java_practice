package com.suri.datastructure.arrays.singledimension;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 * Given an array, find the most frequent element in it. If there are multiple elements that appear maximum number of times, print any one of them.
 *
 * Examples:
 *
 * Input : arr[] = {1, 3, 2, 1, 4, 1}
 * Output : 1
 * 1 appears three times in array which
 * is maximum frequency.
 *
 * Input : arr[] = {10, 20, 10, 20, 30, 20, 20}
 * Output : 20
 */
public class MostFrequentNumber {
  public static void main(String[] args) {
    int arr[] =  {10, 200, 10, 200, 30, 200, 200};
    System.out.println(findMostFrequentElement(arr));

  }

  public static int findMostFrequentElement(int arr[]){

    int n= arr.length;
    for(int i=0;i<n;i++){
      arr[arr[i]%n]+=n;
    }

    int max=0;
    int maxindex=-1;

    for(int i=0;i<n;i++){

      int res = arr[i]/n;

      if(res>max){
        max=res;
        maxindex =i;

      }
    }


   return maxindex;
  }
}

