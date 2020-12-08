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
public class DPFactorial {

    public static void main(String[] args) {

        System.out.println(""+calcFact(5));

    }

    // calculate factorial using Dynamic programming Tabulation

    static long calcFact(int n){
        int lookup[] = new int[n+1];
        lookup[0]=1;
        for(int i=1;i<=n;i++){
           lookup[i] = lookup[i-1]*i;
        }
        return lookup[n];
    }
}
