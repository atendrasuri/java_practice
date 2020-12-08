package com.suri.java.java8.functionalInterface;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 07/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        int a=5;

        Square s= (int x)->x*x;
        System.out.println(""+s.calculate(a));
        s.m1();
        s.m2();

    }

}

@FunctionalInterface
interface Square{

    abstract int calculate(int x);
    public default void m1(){
        System.out.println("Hello");
    }

    public default void m2(){
        System.out.println("Welcome");
    }

}

