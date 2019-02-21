package com.suri.InterviewPractice;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 19/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SegregateEvenOdd {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5,6,7,8};
        display(arr);
        evenNodd(arr);
        //evenNoddSecond(arr);
        System.out.println("  ");
        display(arr);

    }

    public static void display(int arr[]){


        for(int a:arr){
            System.out.print(" "+a);
        }
    }

    public static void evenNodd(int arr[]){


        int n = arr.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]%2!=1){
                int temp = arr[count];
                arr[count]= arr[i];
                arr[i]= temp;
                count++;
            }
        }
    }

    public static void evenNoddSecond(int arr[]){


        int l=0; int h= arr.length-1;

        while(l<h){


            while(arr[l]%2==0 && l<h){
                l++;
            }

            while(arr[h]%2!=0 && l<h){
                h--;
            }

            if(l<h){
                int temp = arr[l];
                arr[l]= arr[h];
                arr[h] = temp;
            }
        }
    }
}