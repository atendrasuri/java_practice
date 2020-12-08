package com.suri.java.string;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/11/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class PermutationString {

    public static void main(String[] args) {
      permutationString("", "123");
    }

    public static void permutationString(String prefix, String str) {
         int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            int i=0;
            for ( ; i <n; i++) {
                permutationString(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
            }
           // System.out.println("hello"+str.charAt(i));
        }
    }
}
