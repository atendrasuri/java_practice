package com.suri.java.java8;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */


interface A{


  default void  m1() {
        System.out.println(" I am in A");
    }
}

interface B{
    default void  m1() {
        System.out.println(" I am in B");
    }
}


public class DiamondProblemTest implements A, B {

    public static void main(String[] args) {

        DiamondProblemTest obj = new DiamondProblemTest();
        obj.m1();
    }


    public void m1() {

        System.out.println(" Hello");
    }
}