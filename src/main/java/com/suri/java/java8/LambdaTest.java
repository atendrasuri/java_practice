package com.suri.java.java8;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 22/02/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class LambdaTest {

    public static void main(String[] args) {

        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(" I am in Thread Hello");
            }
        });

        t1.start();
        System.out.println(" I am in Main");
    }
}