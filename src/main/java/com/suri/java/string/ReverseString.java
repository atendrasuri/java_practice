package com.suri.java.string;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 16/09/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ReverseString {

    public static void main(String args[])
    {
        String str= "surendra";
        System.out.print(reverseString(str));
    }

    public static String reverseString(String str){
        if(str.length()<=1){
            return str;
        }
        return reverseString(str.substring(1))+str.charAt(0);
    }
}
