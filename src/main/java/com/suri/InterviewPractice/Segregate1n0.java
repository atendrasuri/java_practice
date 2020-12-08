package com.suri.InterviewPractice;
import java.lang.*;


class Segregate1n0 {
    public static void main(String[] args) {
        int arr[] = {3, 5, 0, 0, 4};
        moveZero(arr);
        display(arr);

    }

    public static void display(int arr[]) {
        for (int a : arr) {
            System.out.print(" " + a);
        }
    }

    public static void moveZero(int arr[]) {


        int n = arr.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count = count+1;
            }

        }

    }
}