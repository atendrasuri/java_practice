package com.suri.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 03/11/18
 * @Description: (Overwrite)
 * 1. You are given an array of size N . You have to find maximum sum from the array where i<j and A[i] is multiple of A[j].
 *
 * For Example :-
 * N=6
 * A[] = 1, 2, 3, 4, 9, 8 Max sum =15
 * A[]= 5, 2, 3, 4, 9, 8 Max sum = 14
 */
public class ProfitMaximization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int max = 0;
        int t = 0;
        List<Integer> maxarr = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            t = arr[j];
            max = arr[j];
            for (int i = 0; i < n; i++) {

                if ((arr[i] % t == 0) && (j < i)) {
                    t = arr[i];
                    max = max + arr[i];
                }
            }
            maxarr.add(max);

        }
        Collections.sort(maxarr);
        System.out.println(maxarr.get(maxarr.size() - 1));
    }


}

