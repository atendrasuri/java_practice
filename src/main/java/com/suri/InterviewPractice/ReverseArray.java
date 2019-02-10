package com.suri.InterviewPractice;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ReverseArray {

    public static void main(String[] args) {


        int arr[] = {1,2,3,4,5,6,7,8};

        display(arr);
        reverseArray(arr);
        display(arr);

    }

    public static void reverseArray(int arr[]){
        int s=0;
        int e = arr.length-1;
        while(s<e){

            int temp=arr[s]; arr[s]=arr[e]; arr[e]=temp;
           s++;
           e--;
        }
    }


    public static void display(int arr[]){

        for(int i=0;i<arr.length;i++){
            System.out.println(" "+arr[i]);
        }
    }
}