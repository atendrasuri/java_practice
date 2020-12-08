package com.suri.java.object;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 13/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */


class A{
 int x=20;
    public void ptintA(){
        System.out.println(" print A method");
    }

    public static void printA1(){
        System.out.println(" print A1 method");
    }
}


class B extends A{
    public int x=5;
    public void ptintA(){
        System.out.println(" print B method");
    }

    public static void printA1(){
        System.out.println(" print B1 method");
    }
}
public class OopsConcept {



    public static void main(String[] args) {
        Integer abc=20;

        abc.toString();
        A a= new B();
        a.ptintA();
        a.printA1();
        System.out.println(a.x);


        Fun1(null);




    }

    public static void Fun1(A a)
    {

        System.out.println("hello");
    }

    public static void Fun1(B b)
    {

        System.out.println("hello1");
    }

}
