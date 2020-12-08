package com.suri.problemsolving.dynamicprogramming;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 10/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class DPFibonacci {

    public static void main(String[] args) {

        int max = 10;
        int lookup[] = new int[max];
        System.out.println("" + fib(lookup, 8));
        System.out.println("" + fib1(8));


    }

    // using memoization
    public static int fib(int lookup[], int n) {
        if (lookup[n] == 0) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fib(lookup, n - 1) + fib(lookup, n - 2);
            }
        }
        return lookup[n];
    }


    // using tabulation
    public static int fib1(int n) {

        int lookup[] = new int[n + 2];
        lookup[0] = 0;
        lookup[1] = 1;

        for (int i = 2; i <= n; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2];
        }
        return lookup[n];
    }
}
