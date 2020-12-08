package com.suri.datastructure.bitmanipulation;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 08/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class IsNumberPowerTwo {

    public static void main(String[] args) {

        int n=5;

        int res= n&(n-1);
        if(res==0){
            System.out.println(" "+n+"  is power of two");
        }
        else
        {
            System.out.println(" "+n+" is not power of two");
        }



    }

}